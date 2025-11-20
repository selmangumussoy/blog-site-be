package com.example.blogsitebe.domain.platform.message.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Message.TABLE)
public class Message extends AbstractEntity {

    public static final String TABLE = "message";
    public static final String COL_SENDER_ID = "sender_id";
    public static final String COL_RECEIVER_ID = "receiver_id";
    public static final String COL_CONTENT = "content";
    public static final String COL_SEEN = "seen";

    @Column(name = COL_SENDER_ID, nullable = false)
    private String senderId;

    @Column(name = COL_RECEIVER_ID, nullable = false)
    private String receiverId;

    @Column(name = COL_CONTENT, columnDefinition = "TEXT")
    private String content;

    @Column(name = COL_SEEN)
    private Boolean seen = false;
}
