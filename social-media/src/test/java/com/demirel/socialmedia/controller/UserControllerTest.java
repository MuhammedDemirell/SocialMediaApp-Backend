package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.UserDto;
import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreateUserRequest;
import com.demirel.socialmedia.repository.UserRepository;
import com.demirel.socialmedia.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
class UserControllerTest {

    @InjectMocks
    private UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        UserRepository userRepository = mock(UserRepository.class);

        List<User> usersToSave = new ArrayList<>();
        usersToSave.add(new User(1L, "muhammed", "123", null, null, null, 1));
        usersToSave.add(new User(2L, "melih", "321", null, null, null, 1));

        when(userRepository.saveAll(usersToSave)).thenReturn(usersToSave);

        when(userRepository.findAll()).thenReturn(usersToSave);

        List<User> savedUsers = userRepository.saveAll(usersToSave);
        List<User> retrievedUsers = userRepository.findAll();

        assertEquals(usersToSave, savedUsers);
        assertEquals(usersToSave, retrievedUsers);

    }
    @Test
    void createUser() {
        CreateUserRequest mockCreateUserRequest = new CreateUserRequest();
        mockCreateUserRequest.setUserName("muhammed");
        mockCreateUserRequest.setPassword("12345");
        mockCreateUserRequest.setAvatar(1);
        assertEquals("muhammed", mockCreateUserRequest.getUserName());
        assertEquals("12345", mockCreateUserRequest.getPassword());
        assertEquals(1, mockCreateUserRequest.getAvatar());
    }

    @Test
    void getUserById() {
        Long mockId = 1L;
        when(userRepository.existsById(mockId)).thenReturn(true);
        assertTrue(userRepository.existsById(mockId));
        verify(userRepository, times(1)).existsById(mockId);

    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUser() {
        long mockId = 1L;
        userRepository.deleteById(mockId);
        verify(userRepository, times(1)).deleteById(mockId);

    }
}