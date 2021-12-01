package com.disney.explore.service;

import com.disney.explore.domain.entity.Character;
import com.disney.explore.domain.request.CharacterRequest;
import com.disney.explore.domain.response.CharacterResponseDetail;
import com.disney.explore.domain.response.CharacterResponseDetailList;
import com.disney.explore.domain.response.CharacterResponseList;

public interface ICharacterService {

  CharacterResponseList findAll();

  CharacterResponseDetail create(CharacterRequest character);

  CharacterResponseDetail update(long id, CharacterRequest character);

  void delete(long id);

  CharacterResponseDetail findByName(String name);

  CharacterResponseDetailList findByAge(int age);

  CharacterResponseDetailList findByMovie(long id);

  Character byId(long id);

}
