package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;
import com.example.blogsitebe.domain.auth.user.api.UserDto;

public class UserMapper {
    public static User toEntity(SignUpDto dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setName(dto.name());
        user.setRole(dto.role());
        user.setSurname(dto.surname());
        user.setPassword(dto.password());
        return user;
    }
    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setRole(dto.getRole());
//        user.setSurname(dto.getSurname());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setProfileId(dto.getProfileId());
        return user;
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .profileId(user.getProfileId())
                .build();
    }
}