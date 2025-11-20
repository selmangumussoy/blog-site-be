package com.example.blogsitebe.domain.platform.message.api;

import com.example.blogsitebe.domain.platform.message.impl.Message;
import com.example.blogsitebe.domain.platform.message.web.MessageRequest;
import com.example.blogsitebe.domain.platform.message.web.MessageResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper implements
        AbstractEntityMapper<Message, MessageDto>,
        AbstractWebMapper<MessageDto, MessageRequest, MessageResponse> {

    @Override
    public Message toEntity(MessageDto dto) {
        Message e = new Message();
        e.setSenderId(dto.getSenderId());
        e.setReceiverId(dto.getReceiverId());
        e.setContent(dto.getContent());
        e.setSeen(dto.getSeen());
        return e;
    }

    @Override
    public MessageDto entityToDto(Message entity) {
        return MessageDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .senderId(entity.getSenderId())
                .receiverId(entity.getReceiverId())
                .content(entity.getContent())
                .seen(entity.getSeen())
                .build();
    }

    @Override
    public MessageDto requestToDto(MessageRequest req) {
        return MessageDto.builder()
                .senderId(req.getSenderId())
                .receiverId(req.getReceiverId())
                .content(req.getContent())
                .seen(req.getSeen())
                .build();
    }

    @Override
    public MessageResponse toResponse(MessageDto dto) {
        return MessageResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .senderId(dto.getSenderId())
                .receiverId(dto.getReceiverId())
                .content(dto.getContent())
                .seen(dto.getSeen())
                .build();
    }
}
