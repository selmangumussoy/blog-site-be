package com.example.blogsitebe.domain.platform.chat.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Chat.TABLE)
public class Chat extends AbstractEntity {

    public static final String TABLE = "chat";
    public static final String COL_USER1_ID = "user1_id";
    public static final String COL_USER2_ID = "user2_id";
    public static final String COL_LAST_MESSAGE = "last_message";

    @Column(name = COL_USER1_ID, nullable = false)
    private String user1Id;

    @Column(name = COL_USER2_ID, nullable = false)
    private String user2Id;

    @Column(name = COL_LAST_MESSAGE, columnDefinition = "TEXT")
    private String lastMessage;
}
