package com.disney.explore.controller;

import com.disney.explore.domain.request.MovieRequest;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;
import com.disney.explore.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping(
        value = "/movies",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseList> findAll() {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @PostMapping(
        value = "/movies",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseDetail> create(@RequestBody MovieRequest movieRequest) {;
        return new ResponseEntity<>(movieService.create(movieRequest), HttpStatus.CREATED);
    }

    @PutMapping(
        value = "/movies/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseDetail> update(@PathVariable Long id, @RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(movieService.update(id, movieRequest), HttpStatus.OK);
    }

    @DeleteMapping(
        value = "/movies/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        movieService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
    @GetMapping(
        value = "/movies{name}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseDetail> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(movieService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(
        value = "/movies{genreId}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseDetailList> findByGenre(@RequestParam(name = "genre") Long id) {
        return new ResponseEntity<>(movieService.findByGenre(id), HttpStatus.OK);
    }

}
