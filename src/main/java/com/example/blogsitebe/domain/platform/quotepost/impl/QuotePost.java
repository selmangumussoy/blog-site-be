package com.example.blogsitebe.domain.platform.quotepost.impl;

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
@Table(name = QuotePost.TABLE)

public class QuotePost  extends AbstractEntity {
    public static final String TABLE = "quote_post";

    public static final String COL_TITLE = "title";
    public static final String COL_BOOK_NAME = "book_name";
    public static final String COL_AUTHOR = "author";
    public static final String COL_QUOTE_PAGE = "quote_page";
    public static final String COL_PUBLISHER = "publisher";
    public static final String COL_TOTAL_PAGES = "total_pages";
    public static final String COL_THOUGHT = "thought";
    public static final String COL_POST_ID = "post_id";


    @Column(name = COL_TITLE, nullable = false)
    private String title;

    @Column(name = COL_BOOK_NAME, nullable = false)
    private String bookName;

    @Column(name = COL_AUTHOR, nullable = false)
    private String author;

    @Column(name = COL_QUOTE_PAGE)
    private Integer quotePage;

    @Column(name = COL_PUBLISHER)
    private String publisher;

    @Column(name = COL_TOTAL_PAGES)
    private Integer totalPages;

    @Column(name = COL_THOUGHT, columnDefinition = "TEXT")
    private String thought;

    @Column(name = COL_POST_ID, nullable = false)
    private String postId;
}



