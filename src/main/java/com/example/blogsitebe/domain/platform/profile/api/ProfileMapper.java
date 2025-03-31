package com.example.blogsitebe.domain.platform.profile.api;

import com.example.blogsitebe.domain.platform.profile.web.ProfileUpdateRequest;
import com.example.blogsitebe.domain.platform.profile.web.ProfileResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileMapper {
    public static ProfileDto toDto(ProfileUpdateRequest request) {
        return ProfileDto.builder()
                .phone(request.getPhone())
                .picture(request.getPicture())
                .bio(request.getBio())
                .birthDay(request.getBirthDay())
                .gender(request.getGender())
                .website(request.getWebsite())
                .socialLinks(request.getSocialLinks())
                .build();
    }

    public static ProfileResponse toResponse(ProfileDto dto) {
        return ProfileResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .picture(dto.getPicture())
                .bio(dto.getBio())
                .birthDay(dto.getBirthDay())
                .gender(dto.getGender())
                .website(dto.getWebsite())
                .socialLinks(dto.getSocialLinks())
                .build();
    }

    // Bir liste ProfileDto'dan ProfileResponse'a dönüşüm
    public static List<ProfileResponse> toResponses(List<ProfileDto> all) {
        return all.stream()
                .map(ProfileMapper::toResponse)
                .collect(Collectors.toList());
    }
}
