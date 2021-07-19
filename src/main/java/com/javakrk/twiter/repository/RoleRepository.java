package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.RoleEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity getRoleEntityByRole(String role);

    RoleEntity getRoleEntityByUserEntities(UserEntity userEntity);
}
