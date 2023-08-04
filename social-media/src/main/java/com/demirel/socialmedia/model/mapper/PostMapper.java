package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "PostMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostDto toPostDto(Post post);


    }

