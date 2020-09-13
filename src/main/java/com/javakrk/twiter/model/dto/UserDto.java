package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private Date birth_date;
    private String country;
    private String city;
}

