package com.demirel.socialmedia.service;

import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public User updateOneUser(Long userId, User newUser) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setAvatar(newUser.getAvatar());
        return userRepository.save(user);


    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
