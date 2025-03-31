package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;

public class ProfileMapper {
    public static Profile  toEntity(ProfileDto dto) {
        return null;
    }

    public static ProfileDto toDto(Profile profile) {
        return ProfileDto.builder()
                .id(profile.getId())
                .bio(profile.getBio())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .picture(profile.getPicture())
                .modified(profile.getModified())
                .created(profile.getCreated())
                .website(profile.getWebsite())
                .birthDay(profile.getBirthDay())
                .firstName(profile.getFirstName())
                .socialLinks(profile.getSocialLinks())
                .lastName(profile.getLastName())
                .gender(profile.getGender())
                .build();

    }
}
