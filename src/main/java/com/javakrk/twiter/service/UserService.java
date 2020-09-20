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

        if (locationService.getLocationEntityByCity(userSecurityDto.getCity()).isEmpty()) {
            LocationEntity locationEntity = modelMapper.map(userSecurityDto, LocationEntity.class);
            locationRepository.save(locationEntity);
        }

        try {
            UserEntity userEntity = modelMapper.map(userSecurityDto, UserEntity.class);
            userEntity.setLocationEntity(locationService.getLocationEntityByCity(userSecurityDto.getCity()).get());

            if (roleService.getRoleEntityByRole("user").isPresent()){
                userEntity.setRoleEntity(roleService.getRoleEntityByRole("user").get());
            }

            userEntity.setPassword(passwordEncoder.encode(userSecurityDto.getPassword()));
            userRepository.save(userEntity);
        } catch (NoSuchElementException ignored) {
        }
    }

}
