package com.javakrk.twiter.service;


import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Optional<LocationEntity> getLocationEntityByCity(String city) {
        return locationRepository.getLocationEntityByCity(city);
    }
}
