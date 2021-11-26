package com.disney.explore.service;

import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.response.CharacterResponse;
import com.disney.explore.repository.CharactersRepo;
import com.disney.explore.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharactersRepo charactersRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<CharacterResponse> getCharDTO() {
        return charactersRepo.findAllDTO();
    }

    @Override
    public void save(Character personaje) {
        charactersRepo.save(personaje);
    }

    @Override
    public void delete(Long id) {
        charactersRepo.delete(id);
    }

    @Override
    public void update(Character personaje) {
        charactersRepo.update(personaje);
    }

    @Override
    public Character getByName(String nombre) {
        Character p = charactersRepo.getByName(nombre);
        return p;
    }

    @Override
    public List<Character> getByAge(Integer edad) {
        List<Character> p = charactersRepo.getByAge(edad);
        return p;
    }

    @Override
    public List<Character> getByMovie(Long id) {
        List<Character> p = charactersRepo.getByMovie(id);
        return p;
    }
}