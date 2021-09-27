package com.disney.explore.repository;

import com.disney.explore.domain.Role;

public interface RoleRepo {
    Role findByName(String name);
}
