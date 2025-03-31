package com.example.blogsitebe.domain.platform.profile.web;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProfileUpdateRequest {
    private String phone;
    private String picture;
    private String bio;
    private String birthDay;
    private String gender;
    private String website;
    private String socialLinks;
}
