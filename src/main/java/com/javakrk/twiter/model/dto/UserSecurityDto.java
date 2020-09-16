package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSecurityDto extends UserLoggetDto {

    private String login;
    private String password;
}
