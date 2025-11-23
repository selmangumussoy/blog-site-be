package com.example.blogsitebe.domain.platform.quotepost.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.Optional;

public interface QuotePostRepository extends AbstractRepository<QuotePost> {
    Optional<QuotePost> findByPostId(String postId);
}
