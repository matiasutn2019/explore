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
    public void registerUser(AppUser user) {
        AppUser userACrear = findByUsername(user.getUsername());
        if (userACrear == null) entityManager.merge(user);
        else System.out.println("El usuario ya existe!!!");
    }

    @Override
    public AppUser findByUsername(String username) {
        String query = "FROM AppUser WHERE username = :username";
        List<AppUser> userFound = entityManager.createQuery(query)
                .setParameter("username", username)
                .getResultList();
        if (userFound.isEmpty()) return null;
        return userFound.get(0);
    }
}
