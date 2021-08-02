package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.BanEntity;
import com.javakrk.twiter.model.dao.LocationEntity;
import com.javakrk.twiter.model.dao.RoleEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserFindDto;

import java.util.List;

public interface AdminService {

    List<UserEntity> getUserByLoginNameSurname(UserFindDto userFindDto);

    UserEntity getUserEntityById(Integer id);

    BanEntity getBanEntityById(Integer id);

    LocationEntity getLocationEntityById(Integer id);

    RoleEntity getRoleEntityById(Integer id);
}
