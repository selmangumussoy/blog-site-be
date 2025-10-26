package com.example.blogsitebe.domain.platform.like.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Like.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like extends AbstractEntity {
    public static final String TABLE = "likes";
    public static final String COL_USER_ID = "user_id";
    public static final String COL_POST_ID = "post_id";

    @Column(name = COL_USER_ID, nullable = false)
    private String userId;

    @Column(name = COL_POST_ID, nullable = false)
    private String postId;
}
