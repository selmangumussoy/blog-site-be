package com.example.blogsitebe.domain.platform.profile.web;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProfileResponse {
    private String id;
    private Date created;
    private Date modified;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String picture;
    private String bio;
    private String birthDay;
    private String gender;
    private String website;
    private String socialLinks;
}
