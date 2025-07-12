package com.example.blogsitebe.domain.auth.user.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private String profileId;

}