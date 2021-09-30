package com.disney.explore.repository;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.MovieDTO;
import com.disney.explore.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MovieRepoImplHib implements MovieRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MovieDTO> findAllDTO() {
        String query = "select new com.disney.explore.dto.MovieDTO(p.image, p.titulo, p.fecha_creacion) from Pelicula_Serie p";
        return entityManager.createQuery(query, MovieDTO.class).getResultList();
    }

    @Override
    public void save(Pelicula_Serie pelicula_serie) {
        entityManager.merge(pelicula_serie);
    }

    @Override
    public void delete(Pelicula_Serie pelicula_serie) {

    }

    @Override
    public Pelicula_Serie getByTitulo(String titulo) {
        String query = "select p from Pelicula_Serie p where p.titulo=:titulo";
        List<Pelicula_Serie> p = entityManager.createQuery(query)
                .setParameter("titulo", titulo)
                .getResultList();
        if (p.isEmpty()) return null;
        return p.get(0);
    }

    @Override
    public List<Pelicula_Serie> getByIdGenero(Integer id) {
        return null;
    }
}
