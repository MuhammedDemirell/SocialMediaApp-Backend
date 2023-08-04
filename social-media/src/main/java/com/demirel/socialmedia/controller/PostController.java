package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import com.demirel.socialmedia.service.PostService;
import com.demirel.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostRepository repository;
    private final PostService postService;


    @GetMapping
    public List<PostDto> getAllUsers() {
        return postService.getAllPosts();
    }
}
