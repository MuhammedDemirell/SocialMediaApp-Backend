package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.CommentDto;

import com.demirel.socialmedia.model.entity.Comment;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreateCommentRequest;
import com.demirel.socialmedia.model.request.CreatePostRequest;
import com.demirel.socialmedia.model.request.UpdateCommentRequest;
import com.demirel.socialmedia.repository.PostRepository;
import com.demirel.socialmedia.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "CommentMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PostMapper.class, UserMapper.class, CommentMapper.class, LikeMapper.class})
@Component
public interface CommentMapper {

     UserRepository userRepository = null;

     PostRepository postRepository = null;

    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "commentId", source = "comment.id")
    @Mapping(target = "text", source = "comment.text")
    @Mapping(target = "likes", source = "comment.likes")
    CommentDto toCommentDto(Comment comment);


    Comment toCommentCreate(CreateCommentRequest createCommentRequest);

    Comment toCommentUpdate(UpdateCommentRequest updateCommentRequest);
}

