package com.example.blogsitebe.domain.platform.profile.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Profile.TABLE)
public class Profile extends AbstractEntity {
    public static final String TABLE = "profile";
    public static final String COL_EMAIL = "email";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PHONE = "phone";
    public static final String COL_PICTURE = "picture";
    public static final String COL_BIO = "bio";
    public static final String COL_BIRTH_DAY = "birth_day";
    public static final String COL_GENDER = "gender";
    public static final String COL_WEBSITE = "website";
    public static final String COL_SOCIAL_LINKS = "social_links";


    @Column(name = COL_EMAIL)
    private String email;

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_USERNAME)
    private String username;

    @Column(name = COL_PHONE)
    private String phone;

    @Column(name = COL_PICTURE)
    private String picture;

    @Column(name = COL_BIO)
    private String bio;

    @Column(name = COL_BIRTH_DAY)
    private String birthDay;

    @Column(name = COL_GENDER)
    private String gender;

    @Column(name = COL_WEBSITE)
    private String website;

    @Column(name = COL_SOCIAL_LINKS)
    private String socialLinks;
}