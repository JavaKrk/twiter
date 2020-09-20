package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.UserLoggetDto;
import com.javakrk.twiter.model.dto.UserSecurityDto;
import com.javakrk.twiter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public void addNewUser(UserSecurityDto userSecurityDto) {
        UserLoggetDto userLoggetDto = modelMapper.map(userSecurityDto, UserLoggetDto.class);
        UserEntity userEntity = modelMapper.map(userLoggetDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userSecurityDto.getPassword()));
        userRepository.save(userEntity);
    }

    public String getNameAndSurnameLoggedUser(){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserEntity> userByLogin = userRepository.getUserByLogin(login);

        return userByLogin
                .map(userEntity -> userEntity.getName() + " " + userEntity.getSurname())
                .orElse(login);
    }
}
