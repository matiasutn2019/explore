package com.disney.explore.repository;

import com.disney.explore.domain.AppUser;

public interface UserRepo {
    void registerUser(AppUser user);
    AppUser findByUsername(String username);
}
