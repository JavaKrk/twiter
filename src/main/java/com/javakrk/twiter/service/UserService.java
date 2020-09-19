package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.LocationDto;
import com.javakrk.twiter.model.dto.UserSecurityDto;
import com.javakrk.twiter.repository.LocationRepository;
import com.javakrk.twiter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    public void addNewUser(UserSecurityDto userSecurityDto, LocationDto locationDto) {

        LocationEntity locationEntity = modelMapper.map(locationDto, LocationEntity.class);
        locationRepository.save(locationEntity);

        UserEntity userEntity = modelMapper.map(userSecurityDto, UserEntity.class);
        userRepository.save(userEntity);
    }

    public int getLocationIdByCity(String city) {
        Optional<LocationEntity> locationByCity = locationRepository.getLocationByCity(city);
        return locationByCity
                .map(LocationEntity::getId)
                .orElse(0);
    }
}
