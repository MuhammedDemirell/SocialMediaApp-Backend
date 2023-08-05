package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreateUserRequest;
import com.demirel.socialmedia.model.request.UpdateUserRequest;
import com.demirel.socialmedia.repository.UserRepository;
import com.demirel.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;



    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<CreateUserRequest> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public UpdateUserRequest updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateOneUser(userId, updateUserRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
