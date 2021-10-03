package com.disney.explore.service;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.dto.MovieDTO;

import java.util.List;

public interface MoviesService {
    List<MovieDTO> getMovieDTO();

    void save(Pelicula_Serie pelicula);

    void update(Pelicula_Serie pelicula);

    void delete(Long id);

    Pelicula_Serie getByName(String name);

    List<Pelicula_Serie> getByGenre(Long id);

    void addGenreToMovie(String titulo, String nombreGenero);
}
