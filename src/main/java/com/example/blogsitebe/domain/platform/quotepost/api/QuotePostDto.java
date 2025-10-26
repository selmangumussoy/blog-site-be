package com.example.blogsitebe.domain.platform.quotepost.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class QuotePostDto extends AbstractDto {
    private String title;
    private String bookName;
    private String author;
    private Integer quotePage;
    private String publisher;
    private Integer totalPages;
    private String thought;
}
