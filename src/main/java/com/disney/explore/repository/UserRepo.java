package com.disney.explore.repository;

import com.disney.explore.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo {
    void registrarUser(AppUser user) throws Exception;
    AppUser findByUsername(AppUser user);
}
