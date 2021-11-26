package com.disney.explore.controller;

import com.disney.explore.domain.request.MovieRequest;
import com.disney.explore.domain.response.MovieResponseDetail;
import com.disney.explore.domain.response.MovieResponseDetailList;
import com.disney.explore.domain.response.MovieResponseList;
import com.disney.explore.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping
    public ResponseEntity<MovieResponseList> findAll() {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieResponseDetail> create(@RequestBody MovieRequest movieRequest) {;
        return new ResponseEntity<>(movieService.create(movieRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MovieResponseDetail> update(@RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(movieService.update(movieRequest), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        movieService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping("{name}")
    public ResponseEntity<MovieResponseDetail> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(movieService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("{genreId}")
    public ResponseEntity<MovieResponseDetailList> findByGenre(@RequestParam(name = "genre") Long id) {
        return new ResponseEntity<>(movieService.findByGenre(id), HttpStatus.OK);
    }

}
