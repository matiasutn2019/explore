package com.disney.explore.repository;

import com.disney.explore.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepo {
    Genero findByNombre(String nombre);
    void save(Genero genero);
}
