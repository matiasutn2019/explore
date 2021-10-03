package com.disney.explore.repository;

import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CharactersRepoImplHib implements CharactersRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonajeDTO> findAllDTO() {
        try {
            String query = "select new com.disney.explore.dto.PersonajeDTO(p.id, p.image, p.nombre) from Personaje p";
            return entityManager.createQuery(query, PersonajeDTO.class).getResultList();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<PersonajeDTO>();
    }

    @Override
    public void save(Personaje personaje) {
        try {
            entityManager.merge(personaje);
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
    public void update(Personaje personaje) {
        try {
            entityManager.remove(getById(personaje.getId()));
            entityManager.merge(personaje);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Personaje getByName(String nombre) {
        try {
            String query = "select new com.disney.explore.domain.Personaje(p.id, p.image, p.nombre, p.edad, p.peso, p.historia) from Personaje p where p.nombre = :name";
            List<Personaje> p = entityManager.createQuery(query, Personaje.class)
                    .setParameter("name", nombre)
                    .getResultList();
            return p.get(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new Personaje();
    }

    @Override
    public List<Personaje> getByAge(Integer edad) {
        try {
            String query = "select new com.disney.explore.domain.Personaje(p.id, p.image, p.nombre, p.edad, p.peso, p.historia) from Personaje p where p.edad = :edad";
            List<Personaje> p = entityManager.createQuery(query, Personaje.class)
                    .setParameter("edad", edad)
                    .getResultList();
            return p;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<Personaje>();
    }

    @Override
    public List<Personaje> getByMovie(Long id) {
        try {
            String query = "select new com.disney.explore.domain.Personaje(p.id, p.image, p.nombre, p.edad, p.peso, p.historia) " +
                    "from Personaje p inner join p.peliculas_series s where s.id = :id";
            List<Personaje> p = entityManager.createQuery(query, Personaje.class)
                    .setParameter("id", id)
                    .getResultList();
            return p;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<Personaje>();
    }

    @Override
    public Personaje getById(Long id) {
        try {
            Personaje p = entityManager.find(Personaje.class, id);
            return p;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new Personaje();
    }
}
