package com.disney.explore.controller;

import com.disney.explore.domain.request.CharacterRequest;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;

import com.disney.explore.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping
    public ResponseEntity<CharacterResponseList> findAll() {
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CharacterResponseDetail> create(@RequestBody CharacterRequest characterRequest) {
        return new ResponseEntity<>(characterService.create(characterRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CharacterResponseDetail> update(@RequestBody CharacterRequest characterRequest) {
        return new ResponseEntity<>(characterService.update(characterRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        characterService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<CharacterResponseDetail> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("{age}")
    public ResponseEntity<CharacterResponseDetailList> findByAge(@RequestParam(name = "age") Integer age) {
        return new ResponseEntity<>(characterService.findByAge(age), HttpStatus.OK);
    }

    @GetMapping("/{movie}")
    public ResponseEntity<CharacterResponseDetailList> findByMovie(@RequestParam(name = "movie") Long movie) {
        return new ResponseEntity<>(characterService.findByMovie(movie), HttpStatus.OK);
    }
}
