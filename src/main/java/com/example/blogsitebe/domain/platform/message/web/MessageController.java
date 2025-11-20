package com.example.blogsitebe.domain.platform.message.web;

import com.example.blogsitebe.domain.platform.message.api.MessageDto;
import com.example.blogsitebe.domain.platform.message.api.MessageMapper;
import com.example.blogsitebe.domain.platform.message.api.MessageService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.MetaResponse;
import com.example.blogsitebe.library.rest.PageResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController extends AbstractController<MessageDto, MessageRequest, MessageResponse> {


    private final MessageService messageService;
    private final MessageMapper messageMapper;

    public MessageController(MessageService service, MessageMapper mapper) {
        super(service, mapper);
        this.messageService = service;
        this.messageMapper = mapper;
    }

    @GetMapping("/chat")
    public Response<PageResponse<MessageResponse>> getChat(
            @RequestParam String user1,
            @RequestParam String user2,
            Pageable pageable
    ) {
        Page<MessageResponse> page = messageService
                .getChatHistory(user1, user2, pageable)
                .map(mapper::toResponse);

        return respond(page);
    }

    @PostMapping("/seen")
    public Response<?> setSeen(
            @RequestParam String readerId,
            @RequestParam String senderId
    ) {
        messageService.markAsSeen(readerId, senderId);
        return new Response<>(MetaResponse.success());
    }
}
