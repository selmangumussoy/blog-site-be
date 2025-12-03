package com.example.blogsitebe.domain.platform.comment.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = Comment.TABLE)
public class Comment extends AbstractEntity {

    public static final String TABLE = "comment";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_USER_ID = "user_id";
    public static final String COL_PARENT_COMMENT_ID = "parent_comment_id";
    public static final String COL_CONTENT = "content";

    @Column(name = COL_POST_ID)
    @NotBlank(message = "Post ID zorunludur.")
    private String postId;

    @Column(name = COL_USER_ID)
    private String userId;

    @Column(name = COL_PARENT_COMMENT_ID)
    private String parentCommentId;

    @Column(name = COL_CONTENT)
    @NotBlank(message = "Yorum içeriği boş olamaz.")
    private String content;
}
