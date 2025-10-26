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

    @Column(name = COL_POST_ID, nullable = false)
    private Long postId;  // Ana Post tablosuna referans ID
}