package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity getRoleEntityByRole(String role);
}
