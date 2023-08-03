package com.demirel.socialmedia.model.dto;

import com.demirel.socialmedia.model.entity.Like;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CommentDto {

    private Long id;

    private String comment;

    private Long postId;

    private Long userId;

    private Long commentId;

    private Set<Like> likes;

}
