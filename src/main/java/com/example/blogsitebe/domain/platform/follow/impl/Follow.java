package com.example.blogsitebe.domain.platform.follow.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = Follow.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow extends AbstractEntity {
    public static final String TABLE = "follow";
    public static final String COL_FOLLOWER_ID = "follower_id";
    public static final String COL_FOLLOWING_ID = "following_id";

    @Column(name = COL_FOLLOWER_ID, nullable = false)
    private String followerId;

    @Column(name = COL_FOLLOWING_ID, nullable = false)
    private String followingId;
}

