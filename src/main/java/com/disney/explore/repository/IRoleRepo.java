package com.disney.explore.repository;

import com.disney.explore.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Long> {

}
