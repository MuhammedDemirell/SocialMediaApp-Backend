package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreateUserRequest;
import com.demirel.socialmedia.model.request.UpdateUserRequest;
import com.demirel.socialmedia.model.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring", uses = {PostMapper.class, LikeMapper.class, CommentMapper.class})
@Component
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUserCreate(CreateUserRequest createUserRequest);

    User toUserUpdate(UpdateUserRequest updateUserRequest, @MappingTarget User user);

}

