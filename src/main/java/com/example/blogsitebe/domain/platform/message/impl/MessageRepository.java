package com.example.blogsitebe.domain.platform.message.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageRepository extends AbstractRepository<Message> {

    // İki kullanıcı arasındaki DM geçmişi
    Page<com.example.blogsitebe.domain.platform.message.impl.Message> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreated(
            String senderId,
            String receiverId,
            String receiverId2,
            String senderId2,
            Pageable pageable
    );
}
