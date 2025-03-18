package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTag;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTagRepository;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagMapper;
import com.example.blogsitebe.domain.platform.tag.impl.TagServiceImpl;
import com.example.blogsitebe.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<ExcerptDto> findAll() {
        List<ExcerptDto> excerptDtos = new ArrayList<>();

        for (Excerpt excerpt : repository.findAll()) {
            List<Tag> tags = new ArrayList<>();
            for (ExcerptTag excerptTag : excerptTagRepository.findByExcerptId(excerpt.getId())) {
                Tag tag = tagService.findById(excerptTag.getTagId()).orElse(null);
                if (tag != null) {
                    tags.add(tag);
                }
            }

            ExcerptDto excerptDto =  ExcerptMapper.toDtoForTag(excerpt, tags);

            excerptDtos.add(excerptDto);
        }

        return excerptDtos;
    }


//    @Override
//    public Page<ExcerptDto> getAll(Pageable pageable) {
//        Page<Excerpt> excerptsPage = repository.findAll(pageable);
//        return excerptsPage.map(excerpt -> {
//            // Her Excerpt'ı ve ilişkili ExcerptTag'leri dönüştürerek ExcerptDto'ya çeviriyoruz
//            List<ExcerptTag> excerptTags = getExcerptTagsByExcerptId(new ExcerptDto(), excerpt.getId());
//            return ExcerptMapper.toDto(excerpt, excerptTags);
//        });
//    }


    public List<ExcerptTag> getExcerptTagsByExcerptId(ExcerptDto dto, String savedExcerptId) {
        List<ExcerptTag> excerptTags = new ArrayList<>();

        if (dto.tagId() != null && !dto.tagId().isEmpty()) {
            for (String tagId : dto.tagId()) {
                Optional<Tag> tag = tagService.findById(tagId);

                tag.ifPresent(t -> {
                    ExcerptTag excerptTag = new ExcerptTag();
                    excerptTag.setExcerptId(savedExcerptId); // Excerpt ID'sini setliyoruz
                    excerptTag.setTagId(t.getId());    // Tag ID'sini setliyoruz
                    excerptTags.add(excerptTag);       // Set'e ekliyoruz
                });
            }
        }

        return excerptTags;
    }

}
