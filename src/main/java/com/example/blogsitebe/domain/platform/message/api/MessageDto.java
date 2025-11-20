package com.example.blogsitebe.domain.platform.message.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class MessageDto extends AbstractDto {
    private String id;
    private String senderId;
    private String receiverId;
    private String content;
    private Boolean seen;
    private LocalDateTime createdAt;
}
