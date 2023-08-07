package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.exception.BusinessValidationException;
import com.demirel.socialmedia.model.exception.BusinessValidationRule;
import com.demirel.socialmedia.model.mapper.PostMapper;
import com.demirel.socialmedia.model.request.CreatePostRequest;
import com.demirel.socialmedia.model.request.UpdatePostRequest;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public List<PostDto> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            List<Post> postList = postRepository.findByUserId(userId.get());

            return postList.stream().map(postMapper::toPostDto).toList();

        } else {
            List<Post> postList = postRepository.findAll();

            return postList.stream().map(postMapper::toPostDto).toList();
        }
    }

    public PostDto getOnePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new BusinessValidationException(BusinessValidationRule.POST_NOT_FOUND));

        return postMapper.toPostDto(post);
    }

    public CreatePostRequest createPost(CreatePostRequest createPostRequest) {
        User user = userRepository.findById(createPostRequest.getUserId())
                .orElseThrow(() -> new BusinessValidationException(BusinessValidationRule.USER_NOT_FOUND));

        Post post = postMapper.toPostCreate(createPostRequest);
        post.setUser(user);

        postRepository.save(post);

        return createPostRequest;
    }

    public UpdatePostRequest updatePost(Long postId, UpdatePostRequest updatePostRequest) {

        Post post = postRepository.findById(postId).orElseThrow();

        post.setText(updatePostRequest.getText());
        post.setTitle(updatePostRequest.getTitle());
        postMapper.toPostUpdate(updatePostRequest, post);
        postRepository.save(post);

        return updatePostRequest;

    }

    public ResponseEntity<Void> deletePostById(Long postId) {
        postRepository.deleteById(postId);

        return ResponseEntity.ok().build();
    }
}
