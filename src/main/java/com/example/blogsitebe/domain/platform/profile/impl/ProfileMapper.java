package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;

public class ProfileMapper {
    public static Profile toEntity(ProfileDto dto) {
        Profile entity = new Profile();
        entity.setBirthDay(dto.getBirthDay());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setWebsite(dto.getWebsite());
        entity.setPicture(dto.getPicture());
        entity.setGender(dto.getGender());
        entity.setBio(dto.getBio());
        entity.setModified(dto.getModified());
        entity.setCreated(dto.getCreated());
        entity.setSocialLinks(dto.getSocialLinks());
        return entity;
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
