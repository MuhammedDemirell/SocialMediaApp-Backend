package com.demirel.socialmedia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userName;

    private String password;

    private int avatar;

    private Set<PostDto> posts;

    private Set<LikeDto> likes;

    private Set<CommentDto> comments;
}
