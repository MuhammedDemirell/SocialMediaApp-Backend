package com.demirel.socialmedia.model.request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {

    private Long id;

    private  Long userId;

    private String title;

    private  String text;
}
