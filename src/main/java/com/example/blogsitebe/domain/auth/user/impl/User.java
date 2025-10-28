package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = User.TABLE)
public class User extends AbstractEntity {
    public static final String TABLE = "users";
    private static final String COL_PASSWORD = "password";
    private static final String COL_PHONE_NUMBER = "phone_number";
    private static final String COL_ROLE = "role";
    private static final String COL_PROFILE_ID = "profile_id";
    private static final String COL_USERNAME = "username";
    private static final String COL_FULL_NAME = "full_name";


    @Column(name = COL_PASSWORD, nullable = false)
    private String password;

    @Column(name = COL_PHONE_NUMBER)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = COL_ROLE, nullable = false)
    private Role role;

    @Column(name = COL_PROFILE_ID)
    private String profileId;

    @Column(name = COL_USERNAME)
    private String userName;

    @Column(name = COL_FULL_NAME)
    private String fullName;
}
