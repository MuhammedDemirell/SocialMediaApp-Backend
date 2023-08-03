package com.demirel.socialmedia.model.dto;

import com.demirel.socialmedia.model.entity.Comment;
import com.demirel.socialmedia.model.entity.Like;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class PostDto {

    private Long id;

    private String post;

    private Long userId;

    private Set<Like> likes;

    private Set<Comment> comments;

    private LocalDateTime createdDate;


}
