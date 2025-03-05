package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;

public class UserMapper {
    public static User toEntity(SignUpDto dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setName(dto.name());
        user.setRole(dto.role());
        user.setPhoneNumber(dto.phoneNumber());
        user.setSurname(dto.surname());
        return user;
    }
}