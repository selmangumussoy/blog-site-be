package com.example.blogsitebe.domain.platform.like.web;

import com.example.blogsitebe.domain.platform.like.api.LikeDto;
import com.example.blogsitebe.domain.platform.like.api.LikeService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes") // "/api/likes" yerine base path kuralına göre düzenle
public class LikeController extends AbstractController<LikeDto, LikeRequest, LikeResponse> {

    private final LikeService likeService;

    public LikeController(LikeService service, AbstractWebMapper<LikeDto, LikeRequest, LikeResponse> mapper) {
        super(service, mapper);
        this.likeService = service;
    }

    // Frontend bu endpoint'e istek atacak
    @PostMapping("/toggle")
    public Response<Boolean> toggleLike(@RequestBody LikeRequest request) {
        boolean isLiked = likeService.toggleLike(request.getUserId(), request.getPostId());
        return respond(isLiked);
    }
}