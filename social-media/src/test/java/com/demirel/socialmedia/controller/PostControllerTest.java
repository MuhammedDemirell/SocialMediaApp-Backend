package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.request.CreatePostRequest;
import com.demirel.socialmedia.model.request.UpdatePostRequest;
import com.demirel.socialmedia.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "application")
class PostControllerTest {

    @MockBean
    private PostService postService;

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Test
    void itShouldCreatePost_WhenPostRequestBody() throws Exception {
        CreatePostRequest mockCreatePostRequest = new CreatePostRequest();
        mockCreatePostRequest.setId(1L);
        mockCreatePostRequest.setUserId(1L);
        mockCreatePostRequest.setTitle("titlePost");
        mockCreatePostRequest.setText("textPost");

        when(postService.createPost(mockCreatePostRequest)).thenReturn(mockCreatePostRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockCreatePostRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().json(asJsonString(mockCreatePostRequest)));
    }

    @Test
    void itShouldDeletePost_WhenGivenPostId() throws Exception {
        Long postId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/posts/{postId}", postId))
                .andExpect(status().isOk());

        verify(postService, times(1)).deletePostById(postId);
    }

    @Test
    void itShouldUpdatePost_WhenGivenPostIdAndRequestBody() throws Exception {
        Long postId = 1L;
        UpdatePostRequest updateRequest = new UpdatePostRequest();
        updateRequest.setTitle("Updated Title");
        updateRequest.setText("Updated Text");

        when(postService.updatePost(eq(postId), any(UpdatePostRequest.class)))
                .thenReturn(updateRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/posts/{postId}", postId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(postId))
                .andExpect(jsonPath("$.title").value(updateRequest.getTitle()))
                .andExpect(jsonPath("$.text").value(updateRequest.getText()));

        verify(postService, times(1)).updatePost(eq(postId), any(UpdatePostRequest.class));
    }

    @Test
    void itShouldGetAllPosts_WhenGivenPost() throws Exception {
        PostDto mockPostDto = new PostDto();
        mockPostDto.setId(1L);
        mockPostDto.setUserId(1L);
        mockPostDto.setTitle("titlePost");
        mockPostDto.setText("textPost");

        when(postService.getAllPosts(null)).thenReturn(java.util.List.of(mockPostDto));

        mockMvc.perform(MockMvcRequestBuilders.get("/posts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(mockPostDto.getId()))
                .andExpect(jsonPath("$[0].userId").value(mockPostDto.getUserId()))
                .andExpect(jsonPath("$[0].title").value(mockPostDto.getTitle()))
                .andExpect(jsonPath("$[0].text").value(mockPostDto.getText()));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
