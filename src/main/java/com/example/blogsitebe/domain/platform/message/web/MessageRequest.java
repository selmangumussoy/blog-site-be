package com.example.blogsitebe.domain.platform.message.web;

import lombok.Data;

@Data
public class MessageRequest {
    private String senderId;
    private String receiverId;
    private String content;
    private Boolean seen;
}
