package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataDto {

    private UserDto userDto;
    private BanDto banDto;
    private LocationDto locationDto;
    private RoleDto roleDto;
}
