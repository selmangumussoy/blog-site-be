package com.example.blogsitebe.domain.platform.message.api;

import com.example.blogsitebe.library.abstraction.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService extends AbstractService<MessageDto> {

    Page<MessageDto> getChatHistory(String user1Id, String user2Id, Pageable pageable);

    void markAsSeen(String readerId, String senderId);

}
