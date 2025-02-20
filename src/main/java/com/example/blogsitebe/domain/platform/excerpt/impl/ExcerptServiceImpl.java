package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTag;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTagRepository;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ExcerptServiceImpl implements ExcerptService {
    private final ExcerptRepository repository;
    private final TagServiceImpl tagService;
    private final ExcerptTagRepository excerptTagRepository;

    @Override
    public ExcerptDto save(ExcerptDto dto) {
        Excerpt savedExcerpt = repository.save(ExcerptMapper.toEntity(new Excerpt(), dto));

        List<ExcerptTag> excerptTags = getExcerptTagsByExcerptId(dto, savedExcerpt.getId());

        if (!excerptTags.isEmpty()) {
            excerptTagRepository.saveAll(excerptTags);
        }
        return ExcerptMapper.toDto(savedExcerpt, getExcerptTagsByExcerptId(dto, savedExcerpt.getId()));
    }

    public List<ExcerptTag> getExcerptTagsByExcerptId(ExcerptDto dto, String excerptId) {
        List<ExcerptTag> excerptTags = new ArrayList<>();

        if (dto.tagId() != null && !dto.tagId().isEmpty()) {
            for (String tagId : dto.tagId()) {
                Optional<Tag> tag = tagService.findById(tagId);

                tag.ifPresent(t -> {
                    ExcerptTag excerptTag = new ExcerptTag();
                    excerptTag.setExcerptId(excerptId); // Excerpt ID'sini setliyoruz
                    excerptTag.setTagId(t.getId());    // Tag ID'sini setliyoruz
                    excerptTags.add(excerptTag);       // Set'e ekliyoruz
                });
            }
        }

        return excerptTags;
    }
}
