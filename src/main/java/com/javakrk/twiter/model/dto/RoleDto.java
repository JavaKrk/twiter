package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RoleDto {

    private int id;
    private String role;
    private Set<UserDto> userDtos;
}
