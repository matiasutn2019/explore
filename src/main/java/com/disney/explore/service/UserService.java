package com.disney.explore.service;

import com.disney.explore.domain.AppUser;
import com.disney.explore.domain.Role;

public interface UserService {
    AppUser findUserByUsername(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    void registrarUser(AppUser user);
}
