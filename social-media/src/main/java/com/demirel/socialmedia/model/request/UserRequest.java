package com.demirel.socialmedia.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;

    private String password;
}
