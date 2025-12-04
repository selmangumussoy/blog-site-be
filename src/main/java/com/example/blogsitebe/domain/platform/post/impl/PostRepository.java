package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.library.abstraction.AbstractRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends AbstractRepository<Post> {
    List<Post> findAllByUserIdOrderByCreatedDesc(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.likeCount = p.likeCount + 1 WHERE p.id = :postId")
    void incrementLikeCount(@Param("postId") String postId);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.likeCount = p.likeCount - 1 WHERE p.id = :postId AND p.likeCount > 0")
    void decrementLikeCount(@Param("postId") String postId);

    @Query("SELECT COUNT(p) FROM Post p WHERE p.type = :type AND p.id IN " +
            "(SELECT pt.postId FROM PostTag pt WHERE pt.tagId IN " +
            "(SELECT t.id FROM Tag t WHERE t.name = :tagName))")
    long countByTagNameAndType(@Param("tagName") String tagName, @Param("type") PostType type);

    @Query("SELECT p FROM Post p WHERE p.id IN " +
            "(SELECT pt.postId FROM PostTag pt WHERE pt.tagId IN " +
            "(SELECT t.id FROM Tag t WHERE t.name = :tagName)) " +
            "ORDER BY p.created DESC")
    List<Post> findLatestByTagName(@Param("tagName") String tagName, Pageable pageable);

    // 1. Kullanıcıya, Etikete ve Tipe göre Sayı Getir (Kartlardaki sayılar için)
    @Query("SELECT COUNT(p) FROM Post p WHERE p.userId = :userId AND p.type = :type AND p.id IN " +
            "(SELECT pt.postId FROM PostTag pt WHERE pt.tagId IN " +
            "(SELECT t.id FROM Tag t WHERE t.name = :tagName))")
    long countByUserIdAndTagNameAndType(@Param("userId") String userId, @Param("tagName") String tagName, @Param("type") PostType type);

    // 2. Kullanıcıya, Etikete ve Tipe göre Listeyi Getir (Karta tıklayınca açılan liste için)
    @Query("SELECT p FROM Post p WHERE p.userId = :userId AND p.type = :type AND p.id IN " +
            "(SELECT pt.postId FROM PostTag pt WHERE pt.tagId IN " +
            "(SELECT t.id FROM Tag t WHERE t.name = :tagName)) " +
            "ORDER BY p.created DESC")
    List<Post> findByUserIdAndTagNameAndType(@Param("userId") String userId, @Param("tagName") String tagName, @Param("type") PostType type);
}

