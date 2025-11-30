package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.post.impl.Post;
import com.example.blogsitebe.domain.platform.posttag.impl.PostTag;
import com.example.blogsitebe.domain.platform.posttag.impl.PostTagRepository;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagRepository;
import com.example.blogsitebe.domain.platform.post.web.PostRequest;
import com.example.blogsitebe.domain.platform.post.web.PostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class PostMapper implements
        AbstractEntityMapper<Post, PostDto>,
        AbstractWebMapper<PostDto, PostRequest, PostResponse> {

    private final UserService userService;
    private final PostTagRepository postTagRepository;
    private final TagRepository tagRepository;

    @Override
    public Post toEntity(PostDto dto) {
        Post e = new Post();
        e.setType(dto.getType());
        e.setParentId(dto.getParentId());
        e.setUserId(dto.getUserId());
        e.setContent(dto.getContent());
        e.setLikeCount(dto.getLikeCount());
        e.setCommentCount(dto.getCommentCount());
        e.setTitle(dto.getTitle());
        return e;
    }

    @Override
    public PostDto entityToDto(Post entity) {

        // 1) PostTag üzerinden ilişkileri çek
        List<PostTag> relations = postTagRepository.findAllByPostId(entity.getId());

        // 2) Tag isimlerini oku
        List<String> tagNames = relations.stream()
                .map(rel -> tagRepository.findById(rel.getTagId()).orElse(null))
                .filter(Objects::nonNull)
                .map(Tag::getName)
                .toList();

        return PostDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .type(entity.getType())
                .parentId(entity.getParentId())
                .userId(entity.getUserId())
                .content(entity.getContent())
                .likeCount(entity.getLikeCount())
                .commentCount(entity.getCommentCount())
                .title(entity.getTitle())
                .tags(tagNames)
                .build();
    }

    @Override
    public PostDto requestToDto(PostRequest req) {
        return PostDto.builder()
                .type(req.getType())
                .parentId(req.getParentId())
                .userId(req.getUserId())
                .content(req.getContent())
                .likeCount(req.getLikeCount())
                .commentCount(req.getCommentCount())
                .title(req.getTitle())
                .tags(req.getTagIds()) // 👈 Artık sadece tagIds kullanıyoruz
                .build();
    }

    @Override
    public PostResponse toResponse(PostDto dto) {

        String username = "Bilinmeyen";
        String fullName = "Anonim";

        try {
            if (dto.getUserId() != null) {
                UserDto user = userService.getById(dto.getUserId());
                username = user.getUserName();
                fullName = user.getFullName();
            }
        } catch (Exception ignored) {}

        return PostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .type(dto.getType())
                .parentId(dto.getParentId())
                .userId(dto.getUserId())
                .content(dto.getContent())
                .likeCount(dto.getLikeCount())
                .commentCount(dto.getCommentCount())
                .title(dto.getTitle())
                .username(username)
                .fullName(fullName)
                .tags(dto.getTags())
                .build();
    }
}