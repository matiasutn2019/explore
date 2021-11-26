package com.disney.explore.repository;

import com.disney.explore.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepo extends JpaRepository<Genre, Long> {
}
