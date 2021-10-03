package com.disney.explore.controller;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.dto.MovieDTO;
import com.disney.explore.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService moviesService;

    @GetMapping("/listado")
    public ResponseEntity<List<MovieDTO>> listCharacters() {
        return ResponseEntity.ok().body(moviesService.getMovieDTO());
    }

    @PostMapping("/crear")
    public ResponseEntity<Pelicula_Serie> createCharacter(@RequestBody Pelicula_Serie pelicula) {
        moviesService.save(pelicula);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<Pelicula_Serie> updateCharacter(@RequestBody Pelicula_Serie pelicula) {
        moviesService.update(pelicula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Long> deleteCharacter(@PathVariable Long id) {
        moviesService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Pelicula_Serie> getByName(@PathVariable String name) {
        return ResponseEntity.ok().body(moviesService.getByName(name));
    }

    @GetMapping("/bygenre/{id}")
    public ResponseEntity<List<Pelicula_Serie>> getByGenre(@PathVariable Long id) {
        return ResponseEntity.ok().body(moviesService.getByGenre(id));
    }

}
