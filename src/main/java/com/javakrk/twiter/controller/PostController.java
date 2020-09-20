package com.javakrk.twiter.controller;

import com.javakrk.twiter.model.dto.PostDto;
import com.javakrk.twiter.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/addpost")
    public ModelAndView getAddPostView() {
        return new ModelAndView("MainPage", "newPost", new PostDto());
    }

    @GetMapping("/posts")
    public String getAllPostsView(Model model) {
        List<PostDto> allPosts = postService.getAllPosts();
        model.addAttribute("allPosts", allPosts);
        return "MainPage";
    }

    @PostMapping("/addpost")
    public String addNewPost(@ModelAttribute PostDto postDto) {
        postService.addNewPost(postDto);
        return "redirect:MainPage";
    }
}
