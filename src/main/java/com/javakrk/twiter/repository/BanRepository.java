package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.BanEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanRepository extends JpaRepository<BanEntity, Integer> {

    BanEntity getBanEntityByUserEntity(UserEntity userEntity);
}
