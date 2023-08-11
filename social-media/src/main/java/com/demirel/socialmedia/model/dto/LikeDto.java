package com.demirel.socialmedia.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {

    private Long id;

    private Long postId;

    private Long likeCount;

    private Long userId;

    private Long commentId;

}
