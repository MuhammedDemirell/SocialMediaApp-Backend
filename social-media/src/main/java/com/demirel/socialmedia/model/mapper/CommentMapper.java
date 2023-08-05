package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.CommentDto;

import com.demirel.socialmedia.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "CommentMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PostMapper.class, UserMapper.class, CommentMapper.class, LikeMapper.class})
@Component
public interface CommentMapper {


    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "commentId", source = "comment.id")
    @Mapping(target = "text", source = "comment.text")
    CommentDto toCommentDto(Comment comment);


}

