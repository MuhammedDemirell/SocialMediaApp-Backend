package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring", uses = {PostMapper.class, LikeMapper.class, CommentMapper.class})
@Component
public interface UserMapper {


    UserDto toUserDto(User user);

}

