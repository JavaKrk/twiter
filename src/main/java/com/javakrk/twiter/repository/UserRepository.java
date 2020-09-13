package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao, Long> {


}
