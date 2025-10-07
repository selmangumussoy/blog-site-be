package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostDto;
import com.example.blogsitebe.domain.platform.post.api.PostMapper;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController extends AbstractController<PostDto,PostRequest,PostResponse> {
    public PostController(PostService service, PostMapper mapper) {
        super(service, mapper);
    }
}
