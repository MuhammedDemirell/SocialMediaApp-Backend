package com.demirel.socialmedia.model.dto;

import com.demirel.socialmedia.model.entity.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;

    private String text;

    private Long postId;

    private Long userId;

    private Long commentId;

    private Set<LikeDto> likes;

}
