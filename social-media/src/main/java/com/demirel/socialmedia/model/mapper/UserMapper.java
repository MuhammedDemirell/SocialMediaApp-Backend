package com.demirel.socialmedia.model.mapper;


import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserDto toUserDto(User user);


    }

