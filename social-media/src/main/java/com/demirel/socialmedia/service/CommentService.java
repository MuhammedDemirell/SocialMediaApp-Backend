package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.dto.CommentDto;
import com.demirel.socialmedia.model.entity.Comment;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.exception.BusinessValidationException;
import com.demirel.socialmedia.model.exception.BusinessValidationRule;
import com.demirel.socialmedia.model.mapper.CommentMapper;
import com.demirel.socialmedia.model.request.CreateCommentRequest;
import com.demirel.socialmedia.model.request.UpdateCommentRequest;
import com.demirel.socialmedia.repository.CommentRepository;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<CommentDto> getAllComments(Long userId,
                                           Long postId) {
        List<Comment> comments;

        if (userId != null && postId != null) {
            comments = commentRepository.findByUserIdAndPostId(userId, postId);
            return comments.stream().map(commentMapper::toCommentDto).toList();

        } else if (userId != null) {
            comments = commentRepository.findByUserId(userId);
            return comments.stream().map(commentMapper::toCommentDto).toList();

        } else if (postId != null) {
            comments = commentRepository.findByPostId(postId);
            return comments.stream().map(commentMapper::toCommentDto).toList();

        } else {
            comments = commentRepository.findAll();
            return comments.stream().map(commentMapper::toCommentDto).toList();
        }

    }

    public CreateCommentRequest createComment(CreateCommentRequest createCommentRequest) {

        User user = userRepository.findById(createCommentRequest.getUserId()).orElseThrow();
        Post post = postRepository.findById(createCommentRequest.getPostId()).orElseThrow();


        if(user != null && post != null) {
            Comment comment = commentMapper.toCommentCreate(createCommentRequest);
            comment.setId(createCommentRequest.getId());
            comment.setPost(post);
            comment.setUser(user);
            comment.setText(createCommentRequest.getText());
            commentRepository.save(comment);
            return createCommentRequest;
        }else
            throw new BusinessValidationException(BusinessValidationRule.USER_AND_POST_NOT_FOUND);
        }


    public UpdateCommentRequest updateComment(Long commentId, UpdateCommentRequest updateCommentRequest) {

        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if (comment != null) {
            comment.setText(updateCommentRequest.getText());
            commentMapper.toCommentUpdate(updateCommentRequest);
            commentRepository.save(comment);

    }
        return updateCommentRequest;
    }

    public void deleteById(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
