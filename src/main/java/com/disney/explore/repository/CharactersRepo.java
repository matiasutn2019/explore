package com.disney.explore.repository;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;

import java.util.List;

public interface CharactersRepo {

    List<PersonajeDTO> findAllDTO();
    void save(Personaje personaje);
    void delete(Personaje personaje);
    Personaje getByName(String nombre);
    List<Personaje> getByAge(Integer edad);
    List<Personaje> getByMovie(Long id);
}
