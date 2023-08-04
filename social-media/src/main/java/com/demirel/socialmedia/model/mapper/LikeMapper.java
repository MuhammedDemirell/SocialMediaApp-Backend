package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.LikeDto;
import com.demirel.socialmedia.model.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "LikeMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE , uses = {PostMapper.class,UserMapper.class,CommentMapper.class,LikeMapper.class})
@Component
public interface LikeMapper {


    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "commentId", source = "comment.id")
    LikeDto toLikeDto(Like like);


    }

