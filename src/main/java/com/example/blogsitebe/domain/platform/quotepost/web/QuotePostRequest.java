package com.example.blogsitebe.domain.platform.quotepost.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotePostRequest {
    private String title;
    private String bookName;
    private String author;
    private Integer quotePage;
    private String publisher;
    private Integer totalPages;
    private String thought;
    private String postId;

}
