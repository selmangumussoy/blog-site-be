package com.example.blogsitebe.domain.platform.userstats.impl;


import com.example.blogsitebe.domain.platform.tag.impl.Tag;
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
public class UserStats extends AbstractEntity {
    public static final String TABLE = "user_stats";

    public static final String COL_USER_ID= "user_id";
    public static final String COL_FOLLOWERS_COUNT= "follower_count";
    public static final String COL_FOLLOWED_COUNT= "followed_count";
    public static final String COL_POST_COUNT = "post_count";

    @Column(name = COL_USER_ID)
    private String userId;

    @Column(name = COL_FOLLOWERS_COUNT)
    private Integer followerCount;

    @Column(name = COL_FOLLOWED_COUNT)
    private Integer followedCount;

    @Column(name = COL_POST_COUNT)
    private Integer postCount;

}
