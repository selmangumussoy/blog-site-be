package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.user.api.Role;

public record SignUpDto(
        String password,
        String email,
        String name,
        String surname,
        String phoneNumber,
        Role role
) {

}