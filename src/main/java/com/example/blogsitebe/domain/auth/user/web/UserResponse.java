package com.example.blogsitebe.domain.auth.user.web;

import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserResponse extends AbstractResponse {
    private Role role;
    private String profileId;
    private String userName;
    private String phoneNumber;
    private String fullName;
}