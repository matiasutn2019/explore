package com.disney.explore.repository;

import com.disney.explore.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
