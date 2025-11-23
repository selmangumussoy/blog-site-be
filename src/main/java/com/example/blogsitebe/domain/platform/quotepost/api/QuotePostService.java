package com.example.blogsitebe.domain.platform.quotepost.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

public interface QuotePostService extends AbstractService<QuotePostDto> {

    QuotePostDto getByPostId(String postId);

}
