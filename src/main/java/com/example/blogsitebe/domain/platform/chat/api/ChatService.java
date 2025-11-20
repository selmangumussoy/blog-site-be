package com.example.blogsitebe.domain.platform.chat.api;

import com.example.blogsitebe.library.abstraction.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatService extends AbstractService<ChatDto> {

    Page<ChatDto> getMyChats(String userId, Pageable pageable);

    ChatDto getOrCreateChat(String user1Id, String user2Id);
    void updateLastMessage(String senderId, String receiverId, String lastMessage);

}
