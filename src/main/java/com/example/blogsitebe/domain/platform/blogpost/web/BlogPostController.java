package com.example.blogsitebe.domain.platform.blogpost.web;

import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostDto;
import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostMapper;
import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController extends AbstractController<BlogPostDto, BlogPostRequest, BlogPostResponse> {

    private final BlogPostService service;

    public BlogPostController(BlogPostService service, BlogPostMapper mapper) {
        super(service, mapper);
        this.service = service;
    }
    @GetMapping("/by-post/{postId}")
    public Response<BlogPostResponse> getBlogPostByPostId(@PathVariable String postId) {
        BlogPostDto dto = service.getByPostId(postId);
        if (dto == null) {
            return respond(BlogPostResponse.builder().build()); // Boş dönebiliriz veya hata fırlatabiliriz
        }
        return respond(mapper.toResponse(dto));
    }
}
