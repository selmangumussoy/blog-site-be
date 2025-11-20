package com.example.blogsitebe.domain.platform.message.web;

import com.example.blogsitebe.domain.platform.message.api.MessageDto;
import lombok.Data;

@Data
public class MessageWebSocketRequest {
    private String senderId;
    private String receiverId;
    private String content;

    public MessageDto toMessageDto() {
        return MessageDto.builder()
                .senderId(senderId)
                .receiverId(receiverId)
                .content(content)
                .seen(false)
                .build();
    }

}
