package com.javakrk.twiter.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDto {

    private int id;
    private Date date;
    private String text;
    private UserDto userDto;
    private PostDto postDto;
}
