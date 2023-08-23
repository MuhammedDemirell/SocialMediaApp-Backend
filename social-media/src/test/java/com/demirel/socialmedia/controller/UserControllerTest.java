package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.entity.User;
import com.demirel.socialmedia.model.request.CreateUserRequest;
import com.demirel.socialmedia.repository.UserRepository;
import com.demirel.socialmedia.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class UserControllerTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        // UserRepository'yi sahte bir nesneyle değiştiriyoruz
        UserRepository userRepository = mock(UserRepository.class);

        // Kaydedilecek kullanıcı listesini oluşturuyoruz
        List<User> usersToSave = new ArrayList<>();
        usersToSave.add(new User(1L, "muhammed", "123", null, null, null, 1));
        usersToSave.add(new User(2L, "melih", "321", null, null, null, 1));

        // saveAll metodunun davranışını tanımlıyoruz
        when(userRepository.saveAll(usersToSave)).thenReturn(usersToSave);

        // findAll metodunun davranışını tanımlıyoruz
        when(userRepository.findAll()).thenReturn(usersToSave);

        // Test işlemlerine devam edebiliriz
        List<User> savedUsers = userRepository.saveAll(usersToSave);
        List<User> retrievedUsers = userRepository.findAll();

        // Kaydedilen ve alınan kullanıcı listelerinin beklenen kullanıcı listesiyle eşleşip eşleşmediğini kontrol ediyoruz
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
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}