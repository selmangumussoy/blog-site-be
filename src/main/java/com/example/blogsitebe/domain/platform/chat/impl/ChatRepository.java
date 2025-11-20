package com.example.blogsitebe.domain.platform.chat.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends AbstractRepository<Chat> {

    // Kullanıcının dahil olduğu tüm konuşmalar
    Page<Chat> findByUser1IdOrUser2IdOrderByModifiedDesc(
            String userId,
            String userId2,
            Pageable pageable
    );

    // İki kişi arasındaki tek sohbet
    Chat findByUser1IdAndUser2IdOrUser2IdAndUser1Id(
            String u1, String u2,
            String u3, String u4
    );

    @Query("""
        SELECT c FROM Chat c 
        WHERE (c.user1Id = :u1 AND c.user2Id = :u2)
           OR (c.user1Id = :u2 AND c.user2Id = :u1)
        """)
    List<Chat> findChatBetweenUsers(String u1, String u2);

}
