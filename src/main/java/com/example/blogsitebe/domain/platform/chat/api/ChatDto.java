package com.example.blogsitebe.domain.platform.chat.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class ChatDto extends AbstractDto {
    private String user1Id;
    private String user2Id;
    private String lastMessage;
}
