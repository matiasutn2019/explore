package com.disney.explore.controller;

import com.disney.explore.domain.request.CharacterRequest;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;

import com.disney.explore.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping(
        value = "/characters",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseList> findAll() {
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @PostMapping(
        value = "/characters",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseDetail> create(@RequestBody CharacterRequest characterRequest) {
        return new ResponseEntity<>(characterService.create(characterRequest), HttpStatus.CREATED);
    }

    @PutMapping(
        value = "/characters/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseDetail> update(@PathVariable Long id, @RequestBody CharacterRequest characterRequest) {
        return new ResponseEntity<>(characterService.update(id, characterRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/characters/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        characterService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping(
        value = "/characters{name}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseDetail> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(
        value = "/characters{age}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseDetailList> findByAge(@RequestParam(name = "age") Integer age) {
        return new ResponseEntity<>(characterService.findByAge(age), HttpStatus.OK);
    }

    @GetMapping(
        value = "/characters{movie}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterResponseDetailList> findByMovie(@RequestParam(name = "movie") Long movie) {
        return new ResponseEntity<>(characterService.findByMovie(movie), HttpStatus.OK);
    }
}
