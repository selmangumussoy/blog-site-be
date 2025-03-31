package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repository;
    public Profile save(String firstName, String lastName, String email) {
        Profile profile = new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setEmail(email);
        return repository.save(profile);
    }

    @Override
    public ProfileDto update(ProfileDto dto, String id) {
        Profile oldProfile = repository.findById(id).orElseThrow();

        oldProfile.setBio(dto.getBio());
        oldProfile.setPhone(dto.getPhone());
        oldProfile.setGender(dto.getGender());
        oldProfile.setPicture(dto.getPicture());
        oldProfile.setWebsite(dto.getWebsite());
        oldProfile.setSocialLinks(dto.getSocialLinks());
        oldProfile.setBirthDay(dto.getBirthDay());

        return ProfileMapper.toDto(repository.save((oldProfile)));
    }

    @Override
    public List<ProfileDto> getAll() {
        List<ProfileDto> profileDtos = new ArrayList<>();

        for(Profile profile: repository.findAll()){
            profileDtos.add(ProfileMapper.toDto(profile));
        }
        return profileDtos;
    }
}