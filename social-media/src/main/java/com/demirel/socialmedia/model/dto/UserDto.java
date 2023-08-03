package com.demirel.socialmedia.model.dto;

import com.demirel.socialmedia.model.entity.Comment;
import com.demirel.socialmedia.model.entity.Like;
import com.demirel.socialmedia.model.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String userName;

    private String password;

    private int avatar;

    private Set<Post> posts;

    private Set<Like> likes;

    private Set<Comment> comments;

}
