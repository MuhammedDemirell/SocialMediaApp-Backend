package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.dto.LikeDto;
import com.demirel.socialmedia.model.entity.Comment;
import com.demirel.socialmedia.model.entity.Like;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.exception.BusinessValidationException;
import com.demirel.socialmedia.model.exception.BusinessValidationRule;
import com.demirel.socialmedia.model.mapper.LikeMapper;
import com.demirel.socialmedia.model.request.CreateLikeRequest;
import com.demirel.socialmedia.repository.CommentRepository;
import com.demirel.socialmedia.repository.LikeRepository;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<LikeDto> getAllLikes(Long userId,
                                     Long postId,
                                     Long commentId) {
        List<Like> likes;

        if (userId != null && postId != null && commentId != null) {
            likes = likeRepository.findByUserIdAndPostIdAndCommentId(userId, postId, commentId);
            return likes.stream().map(likeMapper::toLikeDto).toList();
        } else if (userId != null) {
            likes = likeRepository.findByUserId(userId);
            return likes.stream().map(likeMapper::toLikeDto).toList();
        } else if (postId != null) {
            likes = likeRepository.findByPostId(postId);
            return likes.stream().map(likeMapper::toLikeDto).toList();
        } else if (commentId != null) {
            likes = likeRepository.findByCommentId(commentId);
            return likes.stream().map(likeMapper::toLikeDto).toList();
        } else {
            likes = likeRepository.findAll();
            return likes.stream().map(likeMapper::toLikeDto).toList();
        }


    }

    public LikeDto getOneLikeById(Long likeId) {
        Like like = likeRepository.findById(likeId).orElseThrow(() -> new BusinessValidationException(BusinessValidationRule.LIKE_NOT_FOUND));
        return likeMapper.toLikeDto(like);

    }

    public CreateLikeRequest createLike(CreateLikeRequest createLikeRequest) {
        User user = userRepository.findById(createLikeRequest.getUserId()).orElseThrow();
        Post post = postRepository.findById(createLikeRequest.getPostId()).orElseThrow();
        Comment comment = commentRepository.findById(createLikeRequest.getCommentId()).orElseThrow();

        if (user != null && post != null && comment != null) {
            Like like = likeMapper.toLikeCreate(createLikeRequest);
            like.setId(createLikeRequest.getId());
            like.setUser(user);
            like.setPost(post);
            like.setComment(comment);
            like.setLikeCount(createLikeRequest.getLikeCount());
            likeRepository.save(like);
            return createLikeRequest;
        } else {
            throw new BusinessValidationException(BusinessValidationRule.LIKE_NOT_CREATED);
        }
    }

    public void deleteLikeById(Long likeId) {
        Like like = likeRepository.findById(likeId).orElseThrow(() -> new BusinessValidationException(BusinessValidationRule.LIKE_NOT_DELETED));
        likeRepository.delete(like);
    }
}
