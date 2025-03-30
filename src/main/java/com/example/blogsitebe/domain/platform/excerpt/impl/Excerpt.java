package com.example.blogsitebe.domain.platform.excerpt.impl;

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
@Table(name = Excerpt.TABLE)
public class Excerpt extends AbstractEntity {
    public static final String TABLE = "excerpt";
    public static final String COL_CONTENT = "content";
    public static final String COL_USER_ID = "user_id";
    public static final String COL_SOURCE_TITLE = "source_title";
    public static final String COL_PUBLISHER = "publisher";
    public static final String COL_PUBLISH_DATE = "publish_date";
    public static final String COL_PAGE = "page";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_OPTIONAL = "optional";
    public static final String COL_IMAGE = "image";


    @Column(name = COL_CONTENT)
    private String content;

    @Column(name = COL_USER_ID)
    private String userId;

    @Column(name = COL_SOURCE_TITLE)
    private String sourceTitle;

    @Column(name = COL_PUBLISHER)
    private String publisher;

    @Column(name = COL_PUBLISH_DATE)
    private String publishDate;

    @Column(name = COL_PAGE)
    private String page;

    @Column(name = COL_DESCRIPTION)
    private String description;

    @Column(name = COL_OPTIONAL)
    private String optional;

    @Column(name = COL_IMAGE)
    private String image;
}
