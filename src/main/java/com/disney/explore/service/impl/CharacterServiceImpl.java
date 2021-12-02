package com.disney.explore.service.impl;

import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.request.CharacterRequest;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;
import com.disney.explore.repository.ICharacterRepo;
import com.disney.explore.service.ICharacterService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
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
        validate(characters);
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
    public CharacterResponseDetail update(long id, CharacterRequest characterRequest) {
        Optional<Character> characterOptional = characterRepo.findById(id);
        validate(characterOptional);
        Character character = updateCharacter(characterOptional.get(), characterRequest);
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
        Optional<Character> character = characterRepo.findByName(name);
        validate(character);
        return convertUtils.toCharacterResponseDetail(character.get());
    }

    @Override
    @Transactional
    public CharacterResponseDetailList findByAge(int age) {
        List<Character> characters = characterRepo.findByAge(age);
        validate(characters);
        return convertUtils.toCharacterResponseDetailList(characters);
    }

    @Override
    @Transactional
    public CharacterResponseDetailList findByMovie(long id) {
        List<Character> characters = characterRepo.findByMovie(id);
        validate(characters);
        return convertUtils.toCharacterResponseDetailList(characters);
    }

    @Override
    public Character byId(long id) {
        Optional<Character> characterOptional = characterRepo.findById(id);
        validate(characterOptional);
        return characterOptional.get();
    }

    private Character buildCharacter(CharacterRequest characterRequest) {
        Character character = new Character();
        character.setImage(characterRequest.getImage());
        character.setNombre(characterRequest.getNombre());
        character.setEdad(characterRequest.getEdad());
        character.setPeso(characterRequest.getPeso());
        character.setHistoria(characterRequest.getHistoria());
        return character;
    }

    private Character updateCharacter(Character character, CharacterRequest characterRequest) {
        character.setImage(characterRequest.getImage());
        character.setNombre(characterRequest.getNombre());
        character.setEdad(characterRequest.getEdad());
        character.setPeso(characterRequest.getPeso());
        character.setHistoria(characterRequest.getHistoria());
        return character;
    }

    private void validate(Optional<Character> character) {
        if(character.isEmpty()) {
            throw new EntityNotFoundException("The character you are looking for is not registered");
        }
    }

    private void validate(List<Character> characters) {
        if(characters.isEmpty()) {
            throw new EntityNotFoundException("The character you are looking for is not registered");
        }
    }
}