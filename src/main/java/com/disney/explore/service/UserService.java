package com.disney.explore.service;

import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.entity.Role;
import com.disney.explore.domain.response.UserResponse;

public interface UserService {
    User findUserByUsername(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    UserResponse registrarUser(User user);
}
