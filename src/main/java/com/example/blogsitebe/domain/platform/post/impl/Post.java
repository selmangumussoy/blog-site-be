package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
@Table(name = Post.TABLE)
public class Post extends AbstractEntity {
    public static final String TABLE = "post";
    public static final String COL_TITLE = "title";
    public static final String COL_CONTENT = "content";
    public static final String COL_AUTHOR = "author";
    public static final String COL_COVER_IMAGE = "cover_image";
    public static final String COL_PUBLISHED = "published";

    @Column(name = COL_TITLE, nullable = false)
    private String title;


    @Column(name = COL_CONTENT, nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = COL_AUTHOR)
    private String author;

    @Column(name = COL_COVER_IMAGE)
    private String coverImage;

    @Column(name = COL_PUBLISHED, nullable = false)
    private Boolean published = false;


}
