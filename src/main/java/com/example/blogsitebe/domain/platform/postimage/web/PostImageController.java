package com.example.blogsitebe.domain.platform.postimage.web;

import com.example.blogsitebe.domain.platform.postimage.api.PostImageDto;
import com.example.blogsitebe.domain.platform.postimage.api.PostImageMapper;
import com.example.blogsitebe.domain.platform.postimage.api.PostImageService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post-images")
public class PostImageController extends AbstractController<PostImageDto, PostImageRequest, PostImageResponse> {

    private final PostImageService postImageService;

    public PostImageController(PostImageService service, PostImageMapper mapper) {
        super(service, mapper);
        this.postImageService = service;
    }

    @GetMapping("/post/{postId}")
    public List<PostImageResponse> getImagesByPost(@PathVariable Long postId) {
        return postImageService.findByPostId(postId)
                .stream()
                .map(dto -> mapper.toResponse(dto))
                .toList();
    }
}
