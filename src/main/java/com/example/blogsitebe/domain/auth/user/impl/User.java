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
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_SURNAME = "surname";
    private static final String COL_PASSWORD = "password";
    private static final String COL_PHONE_NUMBER = "phone_number";
    private static final String COL_ROLE = "role";
    private static final String COL_PROFILE_ID = "profile_id";

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_SURNAME)
    private String surname;

    @Column(name = COL_EMAIL)
    private String email;

    @Column(name = COL_PASSWORD, nullable = false)
    private String password;

    @Column(name = COL_PHONE_NUMBER)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = COL_ROLE, nullable = false)
    private Role role;

    @Column(name = COL_PROFILE_ID)
    private String profileId;
}
