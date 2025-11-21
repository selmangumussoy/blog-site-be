package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostDto;
import com.example.blogsitebe.domain.platform.post.api.PostMapper;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController extends AbstractController<PostDto, PostRequest, PostResponse> {

    public PostController(PostService service, PostMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/user/{userId}")
    public Response<DataResponse<PostResponse>> getPostsByUser(@PathVariable String userId) {
        List<PostResponse> responseList = ((PostService) service).getAllByUserId(userId)
                .stream()
                .map(mapper::toResponse)
                .toList();

        return respond(responseList);
    }
}
