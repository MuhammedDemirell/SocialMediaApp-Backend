package com.demirel.socialmedia.model.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {

    private String title;

    private String text;
}
