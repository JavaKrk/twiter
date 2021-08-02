package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.BanEntity;
import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.model.dao.RoleEntity;
import com.javakrk.twiter.model.dao.UserEntity;
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
    public UserEntity getUserEntityById(Integer id) {
        Optional<UserEntity> findUserById = userRepository.findById(id);
        if (findUserById.isPresent()) {
            return findUserById.get();
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    @Override
    public BanEntity getBanEntityById(Integer id) {
        Optional<BanEntity> findBanById = banRepository.findById(id);
        if (findBanById.isPresent()) {
            return findBanById.get();
        } else {
            throw new RuntimeException("Ban not found.");
        }
    }

    @Override
    public LocationEntity getLocationEntityById(Integer id) {
        Optional<LocationEntity> findLocationById = locationRepository.findById(id);
        if (findLocationById.isPresent()) {
            return findLocationById.get();
        } else {
            throw new RuntimeException("Location not found.");
        }
    }

    @Override
    public RoleEntity getRoleEntityById(Integer id) {
        Optional<RoleEntity> findRoleById = roleRepository.findById(id);
        if (findRoleById.isPresent()) {
            return findRoleById.get();
        } else {
            throw new RuntimeException("Role not found.");
        }
    }
}
