package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;
import com.example.blogsitebe.domain.auth.user.api.Role;

public class UserMapper {
    public static User toEntity(SignUpDto dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setName(dto.name());
        user.setRole(Role.ROLE_USER);
        user.setSurname(dto.surname());
        user.setPassword(dto.password());
        return user;
    }
}