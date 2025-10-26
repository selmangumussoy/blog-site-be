package com.example.blogsitebe.domain.platform.quotepost.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class QuotePostResponse extends AbstractResponse {
    private String title;
    private String bookName;
    private String author;
    private Integer quotePage;
    private String publisher;
    private Integer totalPages;
    private String thought;

}
