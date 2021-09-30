package com.disney.explore.service;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;

import java.util.List;

public interface CharactersService {

    List<PersonajeDTO> getCharDTO();
    void save(Personaje personaje);
    void delete(String nombre);
    void update(Personaje personaje, String nombre);
    Personaje getByName(String nombre);
    List<Personaje> getByAge(Integer edad);
    List<Personaje> getByMovie(Long id);
    void addMovieToCharacter(String nombre, String titulo);
}
