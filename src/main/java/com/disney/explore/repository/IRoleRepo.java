package com.disney.explore.repository;

import com.disney.explore.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {

    @Query(value = "from Role r where r.name = :name")
    Role findByName(@Param("name") String name);
}
