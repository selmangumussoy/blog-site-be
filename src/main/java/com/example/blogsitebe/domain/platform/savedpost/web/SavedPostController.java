package com.example.blogsitebe.domain.platform.savedpost.web;

import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostDto;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostMapper;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/saved-posts")
@Validated
public class SavedPostController extends AbstractController<SavedPostDto, SavedPostRequest, SavedPostResponse> {

    private final SavedPostService savedPostService;

    public SavedPostController(SavedPostService service, SavedPostMapper mapper) {
        super(service, mapper);
        this.savedPostService = service;
    }

    @GetMapping("/user/{userId}")
    public Response<DataResponse<SavedPostResponse>> getUserSavedPosts(@PathVariable String userId) {
        // this.savedPostService kullanarak çağırıyoruz
        List<SavedPostDto> dtos = this.savedPostService.getListByUserId(userId);

        List<SavedPostResponse> responseList = dtos.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return respond(responseList);
    }
}