package com.demirel.socialmedia.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {

    private Long id;

    private Long userId;

    private Long postId;

    private String text;

}
