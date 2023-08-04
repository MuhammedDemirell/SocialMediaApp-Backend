package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.mapper.PostMapper;
import com.demirel.socialmedia.model.mapper.UserMapper;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(postMapper::toPostDto).toList();
    }

}
