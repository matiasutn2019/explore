package com.disney.explore.service;

import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.response.MovieResponse;

import java.util.List;

public interface MovieService {
    List<MovieResponse> getMovieDTO();

    MovieResponse save(Movie pelicula);

    MovieResponse update(Movie pelicula);

    void delete(Long id);

    MovieResponse getByName(String name);

    List<MovieResponse> getByGenre(Long id);
}
