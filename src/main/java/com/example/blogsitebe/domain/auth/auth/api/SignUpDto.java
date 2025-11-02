package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.user.api.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SignUpDto{
    private String password;
    private String phoneNumber;
    private String fullName;
    private String username;
    private Role rol;

}