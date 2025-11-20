package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;
import com.example.blogsitebe.domain.auth.user.api.UserDto;

public class UserMapper {
    public static User toEntity(SignUpDto dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setUserName(dto.getUsername());
        user.setRole(dto.getRol());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
    public static User toEntityForUser(UserDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setFullName(dto.getFullName());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setProfileId(dto.getProfileId());
        return user;
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .fullName(user.getFullName())
                .userName(user.getUserName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .profileId(user.getProfileId())
                .created(user.getCreated())
                .modified(user.getModified())
                .id(user.getId())
                .build();
    }
}