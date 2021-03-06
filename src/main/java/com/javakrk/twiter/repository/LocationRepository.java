package com.javakrk.twiter.repository;

import com.javakrk.twiter.model.dao.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    Optional<LocationEntity> findLocationEntityByCity(String city);
}
