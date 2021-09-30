package com.disney.explore.repository;

import com.disney.explore.domain.Personaje;
import com.disney.explore.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CharactersRepoImplHib implements CharactersRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonajeDTO> findAllDTO() {
        String query = "select new com.disney.explore.dto.PersonajeDTO(p.image, p.nombre) from Personaje p";
        return entityManager.createQuery(query, PersonajeDTO.class).getResultList();
    }

    @Override
    public void save(Personaje personaje) {
        entityManager.merge(personaje);
    }

    @Override
    public void delete(Personaje personaje) {
        entityManager.remove(personaje);
    }

    @Override
    public Personaje getByName(String nombre) {
        String query = "select p from Personaje p where p.nombre=:nombre";
        List<Personaje> p = entityManager.createQuery(query)
                .setParameter("nombre", nombre)
                .getResultList();
        if (p.isEmpty()) return null;
        return p.get(0);
    }

    @Override
    public List<Personaje> getByAge(Integer edad) {
        String query = "select p from Personaje p where p.edad=:edad";
        List<Personaje> p = entityManager.createQuery(query)
                .setParameter("edad", edad)
                .getResultList();
        if (p.isEmpty()) return null;
        return p;
    }

    @Override
    public List<Personaje> getByMovie(Long id) {
        String query = "select p from Personaje p where p.listPersonajePeli.id=:id";
        List<Personaje> p = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        if (p.isEmpty()) return null;
        return p;
    }
}
