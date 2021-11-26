package com.disney.explore.repository;

import com.disney.explore.domain.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactersRepo extends JpaRepository<Character, Long> {

}
