package com.example.blogsitebe.domain.platform.message.web;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MessageResponse extends AbstractDto {
    private String senderId;
    private String receiverId;
    private String content;
    private Boolean seen;
}
