package com.disney.explore.controller;

import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;
import com.disney.explore.service.CharactersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharactersController {

    private final CharactersService charactersService;

    @GetMapping("/listado")
    public ResponseEntity<List<PersonajeDTO>> listCharacters() {
        return ResponseEntity.ok().body(charactersService.getCharDTO());
    }

    @PostMapping("/crear")
    public ResponseEntity<Personaje> createCharacter(@RequestBody Personaje personaje) {
        charactersService.save(personaje);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity updateCharacter(@RequestBody Personaje personaje, String nombre) {
        charactersService.update(personaje, nombre);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity deleteCharacter(@PathVariable String nombre) {
        charactersService.delete(nombre);
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "{name}")
    public ResponseEntity getByName(@PathVariable("name") String nombre) {
        return ResponseEntity.ok().body(charactersService.getByName(nombre));
    }

    @GetMapping(path = "{age}")
    public ResponseEntity getByAge(@PathVariable("age") Integer edad) {
        return ResponseEntity.ok().body(charactersService.getByAge(edad));
    }

    @GetMapping(path = "{movies}")
    public ResponseEntity getByMovies(@PathVariable("movies") Long idMovie) {
        return ResponseEntity.ok().body(charactersService.getByMovie(idMovie));
    }


}
