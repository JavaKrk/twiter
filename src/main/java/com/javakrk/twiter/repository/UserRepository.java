package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> getUserByLogin(@Param("login") String login);
}
