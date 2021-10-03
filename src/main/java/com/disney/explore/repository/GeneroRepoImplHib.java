package com.disney.explore.repository;

import com.disney.explore.domain.Genero;
import com.disney.explore.domain.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class GeneroRepoImplHib implements GeneroRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genero findByNombre(String nombre) {
        try {
            String query = "select new com.disney.explore.domain.Genero(p.id, p.nombre, p.image) from Genero p where p.nombre = :name";
            List<Genero> p = entityManager.createQuery(query, Genero.class)
                    .setParameter("name", nombre)
                    .getResultList();
            if (!p.isEmpty())
                return p.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Genero();
    }

    @Override
    public void save(Genero genero) {
        entityManager.merge(genero);
    }
}
