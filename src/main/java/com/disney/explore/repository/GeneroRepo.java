package com.disney.explore.repository;

import com.disney.explore.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepo extends JpaRepository<Genero, Long> {
    Genero findByName(String name);
}
