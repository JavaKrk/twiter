package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserLoggetDto;
import com.javakrk.twiter.model.dto.UserSecurityDto;
import com.javakrk.twiter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public void addNewUser(UserSecurityDto userSecurityDto) {
        UserLoggetDto userLoggetDto = modelMapper.map(userSecurityDto, UserLoggetDto.class);
        UserEntity userEntity = modelMapper.map(userLoggetDto, UserEntity.class);
        userRepository.save(userEntity);
    }
}
