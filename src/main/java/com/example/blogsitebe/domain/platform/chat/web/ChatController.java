package com.example.blogsitebe.domain.platform.chat.web;

import com.example.blogsitebe.domain.platform.chat.api.ChatDto;
import com.example.blogsitebe.domain.platform.chat.api.ChatMapper;
import com.example.blogsitebe.domain.platform.chat.api.ChatService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.PageResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chats")
public class ChatController
        extends AbstractController<ChatDto, ChatRequest, ChatResponse> {

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    public ChatController(ChatService service, ChatMapper mapper) {
        super(service, mapper);
        this.chatService = service;
        this.chatMapper = mapper;
    }

    @GetMapping("/me")
    public Response<PageResponse<ChatResponse>> getMyChats(
            @RequestParam String userId,
            Pageable pageable) {

        Page<ChatResponse> page = chatService
                .getMyChats(userId, pageable)
                .map(chatMapper::toResponse);

        return respond(page);
    }
}
