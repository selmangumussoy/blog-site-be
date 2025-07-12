package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTag;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTagRepository;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagMapper;
import com.example.blogsitebe.domain.platform.tag.impl.TagServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExcerptServiceImpl implements ExcerptService {
    private final ExcerptRepository repository;
    private final TagServiceImpl tagService;
    private final ExcerptTagRepository excerptTagRepository;

    @Override
    public ExcerptDto save(ExcerptDto dto) {
        Excerpt savedExcerpt = repository.save(ExcerptMapper.toEntity(new Excerpt(), dto));
        List<ExcerptTag> excerptTags = getExcerptTagsByExcerptId(dto.getTagDtoList(), savedExcerpt.getId());

        if (!excerptTags.isEmpty()) {
            excerptTagRepository.saveAll(excerptTags);  // ExcerptTag tablosuna kaydediyoruz
        }
        return ExcerptMapper.toDto(savedExcerpt, getTagsByExcerptId(savedExcerpt.getId()));  // Tag'leri ikinci parametre olarak veriyoruz
    }

    private List<Tag> getTagsByExcerptId(String excerptId) {
        List<ExcerptTag> excerptTags = excerptTagRepository.findByExcerptId(excerptId);
        List<Tag> tags = new ArrayList<>();

        for (ExcerptTag excerptTag : excerptTags) {
            Optional<Tag> tag = tagService.findById(excerptTag.getTagId());
            tag.ifPresent(tags::add);
        }

        return tags;
    }

    public List<ExcerptTag> getExcerptTagsByExcerptId(List<TagDto> tagDtoList, String excerptId) {
        List<ExcerptTag> excerptTags = new ArrayList<>();

        if (tagDtoList != null && !tagDtoList.isEmpty()) {
            for (TagDto tagDto : tagDtoList) {
                Optional<Tag> tag = tagService.findById(tagDto.getId());

                tag.ifPresent(t -> {
                    ExcerptTag excerptTag = new ExcerptTag();
                    excerptTag.setExcerptId(excerptId);  // Excerpt ID'sini setliyoruz
                    excerptTag.setTagId(t.getId());  // Tag ID'sini setliyoruz
                    excerptTags.add(excerptTag);  // Listeye ekliyoruz
                });
            }
        }

        return excerptTags;
    }

    @Override
    public List<ExcerptDto> getAll() {
        List<Excerpt> excerpts = repository.findAllCustom();
        return getAllExcerptDto(excerpts);
    }

    @Override
    public List<ExcerptDto> getExcerptsByUserId(String id) {
         List<Excerpt> excerpts = repository.findByUserId(id);
        return getAllExcerptDto(excerpts);
    }

    public List<ExcerptDto> getAllExcerptDto(List<Excerpt> excerpts){
        List<ExcerptDto> excerptDtos = new ArrayList<>();

        for (Excerpt excerpt : excerpts) {
            List<Tag> tags = tagService.findTagsByExcerptId(excerpt.getId());

            List<TagDto> tagDtoList = tags.stream()
                    .map(TagMapper::toDto)  // TagMapper kullanarak dönüştürme
                    .collect(Collectors.toList());

            excerptDtos.add(ExcerptDto.builder()
                    .id(excerpt.getId())
                    .created(excerpt.getCreated())
                    .modified(excerpt.getModified())
                    .content(excerpt.getContent())
                    .userId(excerpt.getUserId())
                    .sourceTitle(excerpt.getSourceTitle())
                    .page(excerpt.getPage())
                    .optional(excerpt.getOptional())
                    .publishDate(excerpt.getPublishDate())
                    .description(excerpt.getDescription())
                    .publisher(excerpt.getPublisher())
                    .image(excerpt.getImage())
                    .tagDtoList(tagDtoList)  // TagDto listesi burada yer alacak
                    .build());
        }
        return excerptDtos;
    }
}