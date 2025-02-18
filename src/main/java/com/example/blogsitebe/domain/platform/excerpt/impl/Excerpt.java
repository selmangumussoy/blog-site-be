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
    public static final String COL_TAG_ID = "tag_id";
    public static final String COL_LANGUAGE= "language";
    public static final String COL_PAGE_NUMBER = "page_number";

    @Column(name = COL_CONTENT)
    private String content;

    @Column(name = COL_USER_ID)
    private String userId;

    @Column(name = COL_SOURCE_TITLE)
    private String sourceTitle;

    @Column(name = COL_TAG_ID)
    private String tagId;

    @Column(name = COL_LANGUAGE)
    private String bookLanguage;

    @Column(name = COL_PAGE_NUMBER)
    private String bookPageNumber;
}
