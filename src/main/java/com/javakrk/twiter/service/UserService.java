package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserSecurityDto;
import com.javakrk.twiter.repository.LocationRepository;
import com.javakrk.twiter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final LocationService locationService;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public void addNewUser(UserSecurityDto userSecurityDto) {

        Optional<LocationEntity> locationEntityByCity = locationService.getLocationEntityByCity(userSecurityDto.getCity());

        if (locationEntityByCity.isPresent()) {
            LocationEntity locationEntity = locationEntityByCity.get();
        } else {
            LocationEntity locationEntity = modelMapper.map(userSecurityDto, LocationEntity.class);
            locationRepository.save(locationEntity);
        }

        UserEntity userEntity = modelMapper.map(userSecurityDto, UserEntity.class);




        userEntity.setLocationEntity(locationService.getLocationEntityByCity(userSecurityDto.getCity()).get());

        try {

            if (roleService.getRoleEntityByRole("user").isPresent()) {
                userEntity.setRoleEntity(roleService.getRoleEntityByRole("user").get());
            }

            userEntity.setPassword(passwordEncoder.encode(userSecurityDto.getPassword()));
            userRepository.save(userEntity);
        } catch (NoSuchElementException ignored) {
        }
    }
}
