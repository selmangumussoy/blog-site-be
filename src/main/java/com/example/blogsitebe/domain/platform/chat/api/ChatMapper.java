package com.example.blogsitebe.domain.platform.chat.api;

import com.example.blogsitebe.domain.platform.chat.impl.Chat;
import com.example.blogsitebe.domain.platform.chat.web.ChatRequest;
import com.example.blogsitebe.domain.platform.chat.web.ChatResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper implements
        AbstractEntityMapper<Chat, ChatDto>,
        AbstractWebMapper<ChatDto, ChatRequest, ChatResponse> {

    @Override
    public Chat toEntity(ChatDto dto) {
        Chat e = new Chat();
        e.setUser1Id(dto.getUser1Id());
        e.setUser2Id(dto.getUser2Id());
        e.setLastMessage(dto.getLastMessage());
        return e;
    }

    @Override
    public ChatDto entityToDto(Chat entity) {
        return ChatDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .user1Id(entity.getUser1Id())
                .user2Id(entity.getUser2Id())
                .lastMessage(entity.getLastMessage())
                .build();
    }

    @Override
    public ChatDto requestToDto(ChatRequest req) {
        return ChatDto.builder()
                .user1Id(req.getUser1Id())
                .user2Id(req.getUser2Id())
                .lastMessage(req.getLastMessage())
                .build();
    }

    @Override
    public ChatResponse toResponse(ChatDto dto) {
        return ChatResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .user1Id(dto.getUser1Id())
                .user2Id(dto.getUser2Id())
                .lastMessage(dto.getLastMessage())
                .build();
    }
}
