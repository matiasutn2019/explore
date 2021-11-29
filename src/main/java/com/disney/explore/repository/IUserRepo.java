package com.disney.explore.repository;

import com.disney.explore.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    @Query(value = "from User u where u.email = :email")
    User findByUsername(@Param("email") String email);

}
