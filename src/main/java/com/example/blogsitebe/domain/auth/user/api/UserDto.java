package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserDto extends AbstractDto {
    private String password;
    private String phoneNumber;
    private Role role;
    private String profileId;
    private String userName;
    private String fullName;
}