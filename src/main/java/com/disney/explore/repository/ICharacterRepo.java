package com.disney.explore.repository;

import com.disney.explore.domain.entity.Character;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepo extends JpaRepository<Character, Long> {

    @Query("from Character c where c.nombre = :nombre")
    Optional<Character> findByName(@Param("nombre") String nombre);

    @Query("from Character c where c.edad = :edad")
    List<Character> findByAge(@Param("edad") int edad);

    @Query("select m.characters from Movie m where m.id = :movieId")
    List<Character> findByMovie(@Param("movieId") long movieId);

}
