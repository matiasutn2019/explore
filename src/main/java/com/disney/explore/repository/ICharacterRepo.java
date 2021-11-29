package com.disney.explore.repository;

import com.disney.explore.domain.entity.Character;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepo extends JpaRepository<Character, Long> {

    @Query("from Character c where c.nombre = :nombre")
    Character findByName(@Param("nombre") String nombre);

    @Query("from Character c where c.edad = :edad")
    List<Character> findByAge(@Param("") int edad);

    @Query("from Character c where c.peliculas = :movieId")
    List<Character> findByMovie(@Param("movieId") long movieId);

}
