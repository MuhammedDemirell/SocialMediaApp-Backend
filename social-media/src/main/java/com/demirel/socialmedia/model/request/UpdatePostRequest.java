package com.demirel.socialmedia.model.request;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {

    private String title;

    private String text;
}
