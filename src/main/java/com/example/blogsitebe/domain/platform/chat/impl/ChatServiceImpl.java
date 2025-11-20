package com.example.blogsitebe.domain.platform.chat.impl;

import com.example.blogsitebe.domain.platform.chat.api.ChatDto;
import com.example.blogsitebe.domain.platform.chat.api.ChatMapper;
import com.example.blogsitebe.domain.platform.chat.api.ChatService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl extends AbstractServiceImpl<Chat, ChatDto> implements ChatService {

    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    public ChatServiceImpl(ChatRepository repository, ChatMapper mapper) {
        super(repository, mapper);
        this.chatRepository = repository;
        this.chatMapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "Chat";
    }

    @Override
    protected void updateEntityFields(Chat entity, ChatDto dto) {
        entity.setUser1Id(dto.getUser1Id());
        entity.setUser2Id(dto.getUser2Id());
        entity.setLastMessage(dto.getLastMessage());
    }

    @Override
    public Page<ChatDto> getMyChats(String userId, Pageable pageable) {
        return chatRepository
                .findByUser1IdOrUser2IdOrderByModifiedDesc(userId, userId, pageable)
                .map(chatMapper::entityToDto);
    }

    @Override
    public ChatDto getOrCreateChat(String u1, String u2) {

        Chat chat = chatRepository
                .findByUser1IdAndUser2IdOrUser2IdAndUser1Id(u1, u2, u1, u2);

        if (chat == null) {
            chat = new Chat();
            chat.setUser1Id(u1);
            chat.setUser2Id(u2);
            chat.setLastMessage(null);
            chatRepository.save(chat);
        }

        return chatMapper.entityToDto(chat);
    }

    @Override
    public void updateLastMessage(String senderId, String receiverId, String lastMessage) {

        List<Chat> chats = chatRepository.findChatBetweenUsers(senderId, receiverId);

        Chat chat;

        if (chats.isEmpty()) {
            chat = new Chat();
            chat.setUser1Id(senderId);
            chat.setUser2Id(receiverId);
        } else {
            // Eğer 2 tane varsa en güncel olanı seç
            chat = chats.get(0);
        }

        chat.setLastMessage(lastMessage);
        chatRepository.save(chat);
    }

}
