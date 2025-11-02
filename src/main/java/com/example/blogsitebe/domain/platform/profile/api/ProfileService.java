package com.example.blogsitebe.domain.platform.profile.api;

import com.example.blogsitebe.domain.platform.profile.impl.Profile;
import com.example.blogsitebe.domain.platform.profile.web.ProfileResponse;

import java.util.List;

public interface ProfileService {
    ProfileDto update(ProfileDto dto, String id);

    List<ProfileDto> getAll();

    ProfileDto getById(String id);

    ProfileDto save(String userName, String fullName, String phoneNumber);
}
