package com.disney.explore.repository;

import com.disney.explore.domain.entity.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepo extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    @Query(value = "from Movie m where m.titulo = :titulo")
    Optional<Movie> findByName(@Param("titulo") String titulo);

    @Query(value = "select g.movies from Genre g where g.id = :genreId")
    List<Movie> findByGenre(@Param("genreId") long genreId);
}
