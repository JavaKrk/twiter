package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> getUserEntityByLoginOrNameOrSurname(String login, String name, String surname);
}
