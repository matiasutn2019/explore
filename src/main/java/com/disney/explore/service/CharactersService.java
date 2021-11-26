package com.disney.explore.service;

import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.response.CharacterResponse;

import java.util.List;

public interface CharacterService {

    List<CharacterResponse> getCharDTO();
    CharacterResponse save(Character personaje);
    void delete(Long id);
    CharacterResponse update(Character personaje);
    CharacterResponse getByName(String nombre);
    List<CharacterResponse> getByAge(Integer edad);
    List<CharacterResponse> getByMovie(Long id);
}
