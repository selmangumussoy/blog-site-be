package com.example.blogsitebe.domain.platform.profile.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProfileResponse extends AbstractResponse {
    private String email;
    private String phone;
    private String picture;
    private String bio;
    private String birthDay;
    private String gender;
    private String website;
    private String socialLinks;
    private String name;
    private String username;
}
