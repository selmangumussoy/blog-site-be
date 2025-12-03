package com.example.blogsitebe.domain.platform.comment.web;

import com.example.blogsitebe.domain.platform.comment.api.CommentDto;
import com.example.blogsitebe.domain.platform.comment.api.CommentMapper;
import com.example.blogsitebe.domain.platform.comment.api.CommentService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentController extends AbstractController<CommentDto, CommentRequest, CommentResponse> {

    private final CommentService service;

    public CommentController(CommentService service, CommentMapper mapper) {
        super(service, mapper);
        this.service = service;
    }

    @GetMapping("/by-post/{postId}")
    public Response<DataResponse<CommentResponse>> getCommentsByPostId(@PathVariable String postId) {
        List<CommentDto> dtos = service.getCommentsByPostId(postId);
        List<CommentResponse> responseList = dtos.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return respond(responseList);
    }
}
