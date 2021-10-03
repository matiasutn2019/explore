package com.disney.explore.repository;

import com.disney.explore.domain.Pelicula_Serie;
import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.MovieDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MovieRepoImplHib implements MovieRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MovieDTO> findAllDTO() {
        try {
            String query = "select new com.disney.explore.dto.MovieDTO(p.image, p.titulo, p.fecha_creacion) from Pelicula_Serie p";
            return entityManager.createQuery(query, MovieDTO.class).getResultList();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<MovieDTO>();
    }

    @Override
    public void save(Pelicula_Serie pelicula_serie) {
        try {
            entityManager.merge(pelicula_serie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.remove(getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pelicula_Serie pelicula_serie) {
        try {
            entityManager.remove(getById(pelicula_serie.getId()));
            entityManager.merge(pelicula_serie);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pelicula_Serie getByTitulo(String titulo) {
        try {
            String query = "select new com.disney.explore.domain.Pelicula_Serie(p.id, p.image, p.titulo, p.fecha_creacion, p.calificacion) from Pelicula_Serie p where p.titulo = :titulo";
            List<Pelicula_Serie> p = entityManager.createQuery(query)
                    .setParameter("titulo", titulo)
                    .getResultList();
            return p.get(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new Pelicula_Serie();
    }

    @Override
    public List<Pelicula_Serie> getByIdGenero(Long id) {
        try {
            String query = "select new com.disney.explore.domain.Pelicula_Serie(p.id, p.image, p.titulo, p.fecha_creacion, p.calificacion) " +
                    "from Pelicula_Serie p inner join p.generos s where s.id = :id";
            List<Pelicula_Serie> p = entityManager.createQuery(query, Pelicula_Serie.class)
                    .setParameter("id", id)
                    .getResultList();
            return p;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<Pelicula_Serie>();
    }

    @Override
    public Pelicula_Serie getById(Long id) {
        try {
            Pelicula_Serie p = entityManager.find(Pelicula_Serie.class, id);
            return p;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new Pelicula_Serie();
    }
}
