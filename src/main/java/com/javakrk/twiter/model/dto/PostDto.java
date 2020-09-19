package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PostDto {

    private int id;
    private String text;
    private Date date;
    private UserDto userDto;
    private Set<CommentDto> commentDtos;
}
