package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Post.TABLE)
public class Post extends AbstractEntity {

    public static final String TABLE = "posts";
    public static final String COL_TYPE = "type";
    public static final String COL_PARENT_ID = "parent_id";
    public static final String COL_USER_ID = "user_id";
    public static final String COL_CONTENT = "content";
    public static final String COL_TAG_ID = "tag_id";
    public static final String COL_LIKE_COUNT = "like_count";
    public static final String COL_COMMENT_COUNT = "comment_count";

    // Enum tipi
    @Enumerated(EnumType.STRING)
    @Column(name = COL_TYPE, nullable = false)
    private PostType type;

    // Orijinal post ilişkisi (örneğin Repost)
    @Column(name = COL_PARENT_ID)
    private String parentId;

    // Post sahibi kullanıcı ID
    @Column(name = COL_USER_ID, nullable = false)
    private String userId;

    // Post içeriği
    @Column(name = COL_CONTENT, columnDefinition = "TEXT")
    private String content;

    // Etiket ilişkisi
    @Column(name = COL_TAG_ID)
    private String tagId;

    // Sayaçlar
    @Column(name = COL_LIKE_COUNT)
    private Integer likeCount = 0;

    @Column(name = COL_COMMENT_COUNT)
    private Integer commentCount = 0;
}