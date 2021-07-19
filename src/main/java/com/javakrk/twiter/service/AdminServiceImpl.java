package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.BanEntity;
import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.model.dao.RoleEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserDataDto;
import com.javakrk.twiter.model.dto.UserFindDto;
import com.javakrk.twiter.repository.BanRepository;
import com.javakrk.twiter.repository.LocationRepository;
import com.javakrk.twiter.repository.RoleRepository;
import com.javakrk.twiter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final BanRepository banRepository;
    private final LocationRepository locationRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserEntity> getUserByLoginNameSurname(UserFindDto userFindDto) {
        return userRepository.getUserEntityByLoginOrNameOrSurname(
                userFindDto.getLogin(),
                userFindDto.getName(),
                userFindDto.getSurname());

    }

    @Override
    public UserDataDto getUserDataById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            BanEntity banEntity = banRepository.getBanEntityByUserEntity(userEntity.get());
            LocationEntity locationEntity = locationRepository.getLocationEntityByUserEntities(userEntity.get());
            RoleEntity roleEntity = roleRepository.getRoleEntityByUserEntities(userEntity.get());
        } else {
            throw new RuntimeException("User nto found for");
        }
        UserDataDto userDataDto = null;
        return ;
    }
}
