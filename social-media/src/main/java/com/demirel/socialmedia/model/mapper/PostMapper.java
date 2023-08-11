package com.demirel.socialmedia.model.mapper;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.request.CreatePostRequest;
import com.demirel.socialmedia.model.request.UpdatePostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "PostMapperImpl", componentModel = "spring", uses = {LikeMapper.class, CommentMapper.class, UserMapper.class, LikeMapper.class})
@Component
public interface PostMapper {
    @Mapping(target = "userId", source = "user.id")
    PostDto toPostDto(Post post);

    @Mapping(target = "user", ignore = true)
    Post toPostCreate(CreatePostRequest createPostRequest);

    Post toPostUpdate(UpdatePostRequest updatePostRequest, @MappingTarget Post post);


}

