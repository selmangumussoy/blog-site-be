package com.example.blogsitebe.domain.platform.message.impl;

import com.example.blogsitebe.domain.platform.message.api.MessageDto;
import com.example.blogsitebe.domain.platform.message.api.MessageMapper;
import com.example.blogsitebe.domain.platform.message.api.MessageService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends AbstractServiceImpl<Message, MessageDto> implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper mapper;

    public MessageServiceImpl(MessageRepository repository, MessageMapper mapper) {
        super(repository, mapper);
        this.messageRepository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return Message.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Message entity, MessageDto dto) {
        entity.setSenderId(dto.getSenderId());
        entity.setReceiverId(dto.getReceiverId());
        entity.setContent(dto.getContent());
        entity.setSeen(dto.getSeen());
    }

    @Override
    public Page<MessageDto> getChatHistory(String user1Id, String user2Id, Pageable pageable) {

        Page<Message> msgs = messageRepository
                .findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreated(
                        user1Id, user2Id,
                        user2Id, user1Id,
                        pageable);

        return msgs.map(mapper::entityToDto);
    }

    @Override
    public void markAsSeen(String readerId, String senderId) {
        messageRepository
                .findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreated(
                        senderId, readerId,
                        "", "", Pageable.unpaged()) // sadece sender→reader
                .stream()
                .filter(m -> !m.getSeen())
                .forEach(m -> m.setSeen(true));
    }
}
