package com.example.blogsitebe.domain.platform.tag.web;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagMapper;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import com.example.blogsitebe.library.rest.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController extends AbstractController<TagDto,TagRequest,TagResponse> {

    public TagController(AbstractService<TagDto> service, AbstractWebMapper<TagDto, TagRequest, TagResponse> mapper) {
        super(service, mapper);
    }
}