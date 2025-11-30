package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.domain.platform.post.api.PostDto;
import com.example.blogsitebe.domain.platform.post.api.PostMapper;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.domain.platform.posttag.impl.PostTag;
import com.example.blogsitebe.domain.platform.posttag.impl.PostTagRepository;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PostServiceImpl extends AbstractServiceImpl<Post, PostDto> implements PostService {

    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;
    private final TagRepository tagRepository;
    private final PostMapper mapper;

    public PostServiceImpl(PostRepository repository,
                           PostTagRepository postTagRepository,
                           TagRepository tagRepository,
                           PostMapper mapper) {
        super(repository, mapper);
        this.postRepository = repository;
        this.postTagRepository = postTagRepository;
        this.tagRepository = tagRepository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "Post";
    }

    @Override
    protected void updateEntityFields(Post entity, PostDto dto) {
        entity.setParentId(dto.getParentId());
        entity.setContent(dto.getContent());
        entity.setLikeCount(dto.getLikeCount());
        entity.setCommentCount(dto.getCommentCount());
        entity.setTitle(dto.getTitle());
    }

    @Override
    @Transactional
    public PostDto create(PostDto dto) {
        // 1) Post'u kaydet
        Post entity = mapper.toEntity(dto);
        // Created/Modified alanlarını AbstractService/EntityListener yönetmiyorsa elle set etmek gerekebilir
        // entity.setCreated(new Date());
        Post saved = postRepository.save(entity);

        // Biriktirilecek Tag ID'leri (Duplicate önlemek için Set kullanıyoruz)
        Set<String> finalTagIdsToLink = new HashSet<>();

        // 2) Frontend'den açıkça gelen Tag ID'leri ekle
        if (dto.getTags() != null) {
            finalTagIdsToLink.addAll(dto.getTags());
        }

        // 3) İçerikteki #hashtag'leri parse et, gerekirse Tag oluştur ve ID'lerini ekle
        Set<String> parsedTagIds = parseAndCreateTagsFromContent(saved.getContent());
        finalTagIdsToLink.addAll(parsedTagIds);

        // 4) Hepsini PostTag tablosuna kaydet
        for (String tagId : finalTagIdsToLink) {
            if (tagId == null || tagId.isBlank()) continue;

            // Zaten ilişki varsa atla (Robustness)
            if (!postTagRepository.existsByPostIdAndTagId(saved.getId(), tagId)) {
                PostTag postTag = new PostTag();
                postTag.setPostId(saved.getId());
                postTag.setTagId(tagId);
                // ID generation AbstractEntity'den otomatik geliyorsa sorun yok.
                // Gelmiyorsa: postTag.setId(UUID.randomUUID().toString());
                postTagRepository.save(postTag);
            }
        }

        // Response için güncel DTO döndür
        return mapper.entityToDto(saved);
    }

    @Override
    public List<PostDto> getAllByUserId(String userId) {
        return postRepository.findAllByUserIdOrderByCreatedDesc(userId)
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }

    private Set<String> parseAndCreateTagsFromContent(String content) {
        Set<String> tagIds = new HashSet<>();
        if (content == null || content.isBlank()) return tagIds;

        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(content);

        Set<String> uniqueTagNames = new HashSet<>();
        while (matcher.find()) {
            String rawName = matcher.group(1);
            if (rawName != null && !rawName.trim().isEmpty()) {
                uniqueTagNames.add(rawName.trim());
            }
        }

        for (String tagName : uniqueTagNames) {
            Optional<Tag> existingOpt = tagRepository.findByNameIgnoreCase(tagName);

            if (existingOpt.isPresent()) {
                tagIds.add(existingOpt.get().getId());
            } else {
                Tag newTag = new Tag();
                newTag.setName(tagName);
                Tag savedTag = tagRepository.save(newTag);
                tagIds.add(savedTag.getId());
            }
        }
        return tagIds;
    }
}