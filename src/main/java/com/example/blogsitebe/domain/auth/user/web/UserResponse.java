package com.example.blogsitebe.domain.auth.user.web;

import com.example.blogsitebe.domain.auth.user.api.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private String profileId;
}