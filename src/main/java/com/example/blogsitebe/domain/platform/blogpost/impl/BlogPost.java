package com.example.blogsitebe.domain.platform.blogpost.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = BlogPost.TABLE)
public class BlogPost extends AbstractEntity {
    public static final String TABLE = "blog_post";
    public static final String COL_BLOG_CONTENT = "blog_content";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_COVER_IMAGE = "cover_image";
    public static final String COL_TITLE = "title";

    @Column(name = COL_BLOG_CONTENT, columnDefinition = "TEXT", nullable = false)
    private String blogContent;

    @Column(name = COL_POST_ID, nullable = false)
    private String postId;

    @Column(name = COL_COVER_IMAGE)
    private String coverImage;

    @Column(name = COL_TITLE)
    private String title;

}
