package com.example.blogsitebe.domain.platform.profile;

import com.example.blogsitebe.domain.platform.profile.api.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}