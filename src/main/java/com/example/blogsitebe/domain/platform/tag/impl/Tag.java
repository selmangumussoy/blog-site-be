package com.example.blogsitebe.domain.platform.tag.impl;

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
@Table(name = Tag.TABLE)
public class Tag extends AbstractEntity {
    public static final String TABLE = "tag";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_DESCRIPTION)
    private String description;

}
