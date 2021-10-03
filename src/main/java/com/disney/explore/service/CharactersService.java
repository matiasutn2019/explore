package com.disney.explore.service;

import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;

import java.util.List;

public interface CharactersService {

    List<PersonajeDTO> getCharDTO();
    void save(Personaje personaje);
    void delete(Long id);
    void update(Personaje personaje);
    Personaje getByName(String nombre);
    List<Personaje> getByAge(Integer edad);
    List<Personaje> getByMovie(Long id);
}
