package com.example.blogsitebe.domain.platform.profile;

import com.example.blogsitebe.library.rest.AbstractEntity;
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

    private String name;

}