package com.demirel.socialmedia.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private Long id;

    private Long userId;

    private String title;

    private String text;

    private Set<LikeDto> likes;

    private Set<CommentDto> comments;

    private LocalDateTime createdDate;
}
