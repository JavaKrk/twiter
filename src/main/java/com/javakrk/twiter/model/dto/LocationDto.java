package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LocationDto {

    private int id;
    private String country;
    private String city;
    private Set<UserDto> userDtos;
}
