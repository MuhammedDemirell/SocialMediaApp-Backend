package com.demirel.socialmedia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {

    private Long id;

    private Long postId;

    private Long likeCount;

    private Long userId;

    private Long commentId;


}
