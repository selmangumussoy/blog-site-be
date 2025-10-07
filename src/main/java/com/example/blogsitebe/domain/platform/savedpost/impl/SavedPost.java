package com.example.blogsitebe.domain.platform.savedpost.impl;

import com.example.blogsitebe.domain.platform.comment.impl.Comment;
import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = SavedPost.TABLE)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SavedPost extends AbstractEntity {
    public static final String TABLE = "saved_post";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_USER_ID = "user_id";

    @Column(name = COL_POST_ID)
    private String postId;

    @Column(name = COL_USER_ID)
    private String userId;

}
