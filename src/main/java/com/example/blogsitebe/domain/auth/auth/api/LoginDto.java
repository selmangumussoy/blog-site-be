package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.user.api.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginDto{
    private String username;
    private String password;
    private Role role;
}
