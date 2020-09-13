package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
