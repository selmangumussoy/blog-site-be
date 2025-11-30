package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repository;

    @Override
    public ProfileDto save(String userName, String fullName, String phone) {
        Profile profile = new Profile();
        profile.setUsername(userName);
        profile.setName(fullName);
        profile.setPhone(phone);

        Profile saved = repository.save(profile);
        return ProfileMapper.toDto(saved);
    }

    @Override
    public ProfileDto update(ProfileDto dto, String id) {

        Profile profile = repository.findById(id)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_NOT_FOUND));

        // Güncellenecek alanlar
        profile.setName(dto.getName());
        profile.setUsername(dto.getUsername());
        profile.setPhone(dto.getPhone());
        profile.setBio(dto.getBio());
        profile.setPicture(dto.getPicture());

        Profile saved = repository.save(profile);

        return ProfileMapper.toDto(saved);
    }


    @Override
    public List<ProfileDto> getAll() {
        List<ProfileDto> profileDtos = new ArrayList<>();

        for(Profile profile: repository.findAll()){
            profileDtos.add(ProfileMapper.toDto(profile));
        }
        return profileDtos;
    }

    @Override
    public ProfileDto getById(String id) {
        var profile = repository.findById(id).orElseThrow();
        return ProfileMapper.toDto(profile);
    }

    @Override
    public ProfileDto getProfileByUsername(String username) {
        Profile profile = repository.findByUsername(username)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_NOT_FOUND ));

        return ProfileMapper.toDto(profile);
    }
}