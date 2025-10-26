package com.example.blogsitebe.domain.platform.savedpost.web;

import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostDto;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostMapper;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostService;
import com.example.blogsitebe.domain.platform.savedpost.impl.SavedPost;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.BaseController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saved-posts")
@Validated
public class SavedPostController extends AbstractController<SavedPostDto, SavedPostRequest, SavedPostResponse> {

    public SavedPostController(SavedPostService service, SavedPostMapper mapper) {
        super(service, mapper);
    }
}
