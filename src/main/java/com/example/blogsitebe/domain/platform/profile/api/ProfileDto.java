package com.example.blogsitebe.domain.platform.profile.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class ProfileDto extends AbstractDto {
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