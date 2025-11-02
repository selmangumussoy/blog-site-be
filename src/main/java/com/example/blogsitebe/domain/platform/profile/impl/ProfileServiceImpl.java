package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import com.example.blogsitebe.library.security.JwtUtil;
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

    public ProfileDto update(ProfileDto dto, String id) {
        Profile oldProfile = repository.findById(id).orElseThrow();
        //TODO update işlemeleri için düzgün bir yapı kurulmaslı ve modified işlemi düzgün setlenmeli
        //todo buradaki created ve modified zorunlu olduğu için eski hali setlenmiştir.
        Profile newProfile = ProfileMapper.toEntity(dto);
        newProfile.setId(oldProfile.getId());
        newProfile.setCreated(oldProfile.getCreated());
        newProfile.setModified(oldProfile.getModified());
        repository.save(oldProfile);

        return ProfileMapper.toDto(repository.save(newProfile));
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
}