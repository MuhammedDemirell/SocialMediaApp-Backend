package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.mapper.UserMapper;
import com.demirel.socialmedia.model.request.CreateUserRequest;
import com.demirel.socialmedia.model.request.UpdateUserRequest;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> list = userList.stream().map(userMapper::toUserDto).toList();
        return list;
    }

    public ResponseEntity<CreateUserRequest> createUser(CreateUserRequest createUserRequest) {
        User user = userMapper.toUserCreate(createUserRequest);
        userRepository.save(user);
        return ResponseEntity.ok().body(createUserRequest);

    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public UpdateUserRequest updateOneUser(Long userId, UpdateUserRequest updateUserRequest ) {

        User user = userRepository.findById(userId).orElseThrow();

        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setAvatar(user.getAvatar());
        userMapper.toUserUpdate(updateUserRequest, user);
        userRepository.save(user);
        return updateUserRequest;


    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
