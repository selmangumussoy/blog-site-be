package com.example.blogsitebe.domain.platform.quotepost.web;

import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostDto;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostMapper;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quote-posts")
public class QuotePostController  extends AbstractController<QuotePostDto, QuotePostRequest, QuotePostResponse> {

    QuotePostService service;
    public QuotePostController(QuotePostService service, QuotePostMapper mapper) {
        super(service, mapper);
    }


    @GetMapping("/by-post/{postId}")
    public Response<QuotePostResponse> getQuotePostByPostId(@PathVariable String postId) {
        QuotePostDto dto = service.getByPostId(postId);
        if (dto == null) {
            return respond(QuotePostResponse.builder().build());
        }
        return respond(mapper.toResponse(dto));
    }
}
