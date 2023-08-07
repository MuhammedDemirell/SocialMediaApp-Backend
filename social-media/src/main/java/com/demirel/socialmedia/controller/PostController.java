package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.PostDto;

import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreatePostRequest;
import com.demirel.socialmedia.model.request.UpdatePostRequest;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;


    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getOnePost(postId);

    }

    @PostMapping
    public CreatePostRequest createPost(@RequestBody CreatePostRequest createPostRequest) {
        return postService.createPost(createPostRequest);
    }

    @PutMapping("/{postId}")
    public UpdatePostRequest updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest) {
        return postService.updatePost(postId, updatePostRequest);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok().build();
    }

}
