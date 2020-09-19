package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BanDto {

    private int id;
    private Date endTime;
    private UserDto userDto;
}
