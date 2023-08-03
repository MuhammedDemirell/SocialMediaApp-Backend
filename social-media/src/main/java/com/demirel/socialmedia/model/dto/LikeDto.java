package com.demirel.socialmedia.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {

    private Long id;

    private Long postId;

    private Long userId;

    private Long commentId;


}
