package com.disney.explore.service.impl;

import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.entity.Movie;
import com.disney.explore.domain.request.CharacterRequest;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;
import com.disney.explore.repository.ICharacterRepo;
import com.disney.explore.service.ICharacterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private ICharacterRepo characterRepo;

    @Autowired
    private ConvertUtils convertUtils;

    @Override
    @Transactional
    public CharacterResponseList findAll() {
        List<Character> characters = characterRepo.findAll();
        return convertUtils.toCharacterResponseList(characters);
    }

    @Override
    @Transactional
    public CharacterResponseDetail create(CharacterRequest characterRequest) {
        Character character = buildCharacter(characterRequest);
        characterRepo.save(character);
        return convertUtils.toCharacterResponseDetail(character);
    }

    @Override
    @Transactional
    public CharacterResponseDetail update(CharacterRequest characterRequest) {
        Character character = buildCharacter(characterRequest);
        characterRepo.save(character);
        return convertUtils.toCharacterResponseDetail(character);
    }

    @Override
    @Transactional
    public void delete(long id) {
        characterRepo.deleteById(id);

    }

    @Override
    @Transactional
    public CharacterResponseDetail findByName(String name) {
        Character character = characterRepo.findByName(name);
        return convertUtils.toCharacterResponseDetail(character);
    }

    @Override
    @Transactional
    public CharacterResponseDetailList findByAge(int age) {
        List<Character> characters = characterRepo.findByAge(age);
        return convertUtils.toCharacterResponseDetailList(characters);
    }

    @Override
    @Transactional
    public CharacterResponseDetailList findByMovie(long id) {
        List<Character> characters = characterRepo.findByMovie(id);
        return convertUtils.toCharacterResponseDetailList(characters);
    }

    private Character buildCharacter(CharacterRequest characterRequest) {
        Character character = new Character();
        character.setImage(characterRequest.getImage());
        character.setNombre(characterRequest.getNombre());
        character.setEdad(characterRequest.getEdad());
        character.setPeso(characterRequest.getPeso());
        character.setHistoria(characterRequest.getHistoria());
        List<Movie> peliculas = new ArrayList<>();
        characterRequest.getPeliculas().forEach(movie -> peliculas.add(movie));
        character.setPeliculas(peliculas);
        return character;
    }
}