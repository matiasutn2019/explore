package com.disney.explore.repository;

import com.disney.explore.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepo extends JpaRepository<Genre, Long> {
}
