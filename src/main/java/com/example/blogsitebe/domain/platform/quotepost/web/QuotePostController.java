package com.example.blogsitebe.domain.platform.quotepost.web;

import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostDto;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostMapper;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quote-posts")
public class QuotePostController  extends AbstractController<QuotePostDto, QuotePostRequest, QuotePostResponse> {
    public QuotePostController(QuotePostService service, QuotePostMapper mapper) {
        super(service, mapper);
    }
}
