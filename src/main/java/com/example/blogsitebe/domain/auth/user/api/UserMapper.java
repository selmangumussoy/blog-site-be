package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.domain.auth.user.web.UserResponse;

public class UserMapper {
    public static UserResponse toResponse(UserDto userDto) {
        return UserResponse.builder()
                .profileId(userDto.getProfileId())
                .role(userDto.getRole())
                .userName(userDto.getUserName())
                .phoneNumber(userDto.getPhoneNumber())
                .fullName(userDto.getFullName())
                .build();
    }
}