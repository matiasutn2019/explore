package com.disney.explore.repository;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.dto.MovieDTO;

import java.util.List;

public interface MovieRepo {
    List<MovieDTO> findAllDTO();
    void save(Pelicula_Serie pelicula_serie);
    void delete(Pelicula_Serie pelicula_serie);
    Pelicula_Serie getByTitulo(String titulo);
    List<Pelicula_Serie> getByIdGenero(Integer id);
}
