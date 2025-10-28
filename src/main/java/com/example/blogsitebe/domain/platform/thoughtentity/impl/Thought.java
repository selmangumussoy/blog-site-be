package com.example.blogsitebe.domain.platform.thoughtentity.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Thought.TABLE)
public class Thought extends AbstractEntity {

    public static final String TABLE = "thought";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_CONTENT = "content";
    public static final String COL_FEELING = "feeling";

    @Column(name = COL_POST_ID, nullable = false)
    private String postId;

    @Column(name = COL_CONTENT, nullable = false, columnDefinition = "TEXT")
    private String content;

    // Emoji/metin saklamak için kısa alan (örn. 🙂 veya "happy")
    @Column(name = COL_FEELING, length = 64)
    private String feeling;
}