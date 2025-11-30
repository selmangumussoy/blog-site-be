package com.example.blogsitebe.domain.platform.like.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = Like.TABLE,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {Like.COL_USER_ID, Like.COL_POST_ID}) // AYNI KİŞİ AYNI POSTU 1 KEZ BEĞENEBİLİR
        }
)
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