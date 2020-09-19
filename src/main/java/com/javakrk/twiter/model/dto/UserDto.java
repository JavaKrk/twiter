package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private int id;
    private String email;
    private String birthDate;
    private String country;
    private String city;
}
