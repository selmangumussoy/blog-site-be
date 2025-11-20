package com.example.blogsitebe.domain.platform.chat.web;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class ChatResponse extends AbstractDto {
    private String user1Id;
    private String user2Id;
    private String lastMessage;
}
