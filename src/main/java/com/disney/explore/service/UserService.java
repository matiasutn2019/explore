package com.disney.explore.service;

import com.disney.explore.domain.AppUser;

public interface UserService {
    void registrarUser(AppUser user) throws Exception;
    AppUser findUserByUsername(AppUser user);
}
