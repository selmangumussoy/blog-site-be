package com.example.blogsitebe.domain.platform.blogpost.web;

import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostDto;
import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostMapper;
import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController extends AbstractController<BlogPostDto, BlogPostRequest, BlogPostResponse> {
    public BlogPostController(BlogPostService service, BlogPostMapper mapper) {
        super(service, mapper);
    }
}
