package com.disney.explore.controller;

import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;
import com.disney.explore.service.CharactersService;
import javassist.NotFoundException;
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
    public ResponseEntity<Personaje> updateCharacter(@RequestBody Personaje personaje) {
        charactersService.update(personaje);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Long> deleteCharacter(@PathVariable Long id) {
        charactersService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Personaje> getByName(@PathVariable String name) {
        return ResponseEntity.ok().body(charactersService.getByName(name));
    }

    @GetMapping("/byage/{age}")
    public ResponseEntity<List<Personaje>> getByAge(@PathVariable Integer age) {
        return ResponseEntity.ok().body(charactersService.getByAge(age));
    }

    @GetMapping("/bymovie/{movieId}")
    public ResponseEntity<List<Personaje>> getByMovies(@PathVariable Long movieId) {
        return ResponseEntity.ok().body(charactersService.getByMovie(movieId));
    }
}
