package com.example.blogsitebe.domain.platform.thoughtentity.web;

import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtDto;
import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtMapper;
import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/thoughts")
public class ThoughtController extends AbstractController<ThoughtDto, ThoughtRequest, ThoughtResponse> {
    public ThoughtController(ThoughtService service, ThoughtMapper mapper) {
        super(service, mapper);
    }
}