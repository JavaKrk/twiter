package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserDataDto;
import com.javakrk.twiter.model.dto.UserFindDto;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    List<UserEntity> getUserByLoginNameSurname(UserFindDto userFindDto);

    UserDataDto getUserDataById(Integer id);
}
