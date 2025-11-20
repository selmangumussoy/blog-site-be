package com.example.blogsitebe.domain.platform.chat.web;

import lombok.Data;

@Data
public class ChatRequest {
    private String user1Id;
    private String user2Id;
    private String lastMessage;
}
