package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSecDto extends UserDto {

    private String login;
    private String email;
    private String password;


}

