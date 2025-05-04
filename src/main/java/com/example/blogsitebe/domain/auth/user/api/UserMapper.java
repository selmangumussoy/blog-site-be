package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.domain.auth.user.web.UserResponse;

public class UserMapper {
    public static UserResponse toResponse(UserDto userDto) {
        return UserResponse.builder()
                .profileId(userDto.getProfileId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .surname(userDto.getSurname())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
    }
}