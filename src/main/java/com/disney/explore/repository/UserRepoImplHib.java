package com.disney.explore.repository;

import com.disney.explore.domain.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepoImplHib implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registrarUser(AppUser user) throws Exception {
        AppUser userACrear = findByUsername(user);
        if (userACrear == null) entityManager.merge(user);
        else {
            throw new Exception("User already registrated!!!");
        }
    }

    @Override
    public AppUser findByUsername(AppUser user) {
        String query = "FROM AppUser WHERE nombre = :nombre";
        List<AppUser> userFound = entityManager.createQuery(query)
                .setParameter("nombre", user.getUsername())
                .getResultList();
        if (userFound.isEmpty()) return null;
        return (AppUser) userFound;
    }
}
