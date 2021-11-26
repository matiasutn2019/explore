package com.disney.explore.controller;

import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.response.MovieResponse;
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
    public ResponseEntity<List<MovieResponse>> listCharacters() {
        return ResponseEntity.ok().body(moviesService.getMovieDTO());
    }

    @PostMapping("/crear")
    public ResponseEntity<Movie> createCharacter(@RequestBody Movie pelicula) {
        moviesService.save(pelicula);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<Movie> updateCharacter(@RequestBody Movie pelicula) {
        moviesService.update(pelicula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Long> deleteCharacter(@PathVariable Long id) {
        moviesService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Movie> getByName(@PathVariable String name) {
        return ResponseEntity.ok().body(moviesService.getByName(name));
    }

    @GetMapping("/bygenre/{id}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable Long id) {
        return ResponseEntity.ok().body(moviesService.getByGenre(id));
    }

}
