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
    public static final String COL_TITLE = "title";
    public static final String COL_POST_ID = "post_id";

    @Column(name = COL_TITLE, nullable = false)
    private String title;

    @Column(name = COL_POST_ID, nullable = false)
    private String postId; // Post.id (ID ile ilişki)

}
