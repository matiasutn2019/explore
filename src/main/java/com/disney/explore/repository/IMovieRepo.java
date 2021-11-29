package com.disney.explore.repository;

import com.disney.explore.domain.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepo extends JpaRepository<Movie, Long> {

    @Query(value = "from Movie m where m.titulo = :titulo")
    Movie findByName(@Param("titulo") String titulo);

    @Query(value = "from Movie m where m.generos = :genreId")
    List<Movie> findByGenre(@Param("genreId") long genreId);
}
