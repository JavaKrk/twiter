package com.javakrk.twiter.service;

import com.javakrk.twiter.model.dao.PostEntity;
import com.javakrk.twiter.model.dao.UserEntity;
import com.javakrk.twiter.model.dto.PostDto;
import com.javakrk.twiter.model.dto.UserDto;
import com.javakrk.twiter.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public void addNewPost(PostDto post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        postRepository.save(postEntity);
    }

    public List<PostDto> getAllPosts(){
        return postRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }
}
