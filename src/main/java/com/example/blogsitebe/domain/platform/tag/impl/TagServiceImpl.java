package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.posttag.impl.PostTagRepository;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class TagServiceImpl extends AbstractServiceImpl<Tag, TagDto> implements TagService {

    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;

    public TagServiceImpl(TagRepository tagRepository,
                          PostTagRepository postTagRepository,
                          AbstractEntityMapper<Tag, TagDto> mapper) {
        super(tagRepository, mapper);
        this.tagRepository = tagRepository;
        this.postTagRepository = postTagRepository;
    }

    @Override
    protected String getEntityName() {
        return Tag.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Tag tag, TagDto tagDto) {
        tag.setName(tagDto.getName());
        tag.setDescription(tagDto.getDescription());
    }

    @Override
    public List<TagDto> search(String query) {
        return tagRepository.findByNameContainingIgnoreCase(query)
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    public List<TagDto> getTrendingDaily() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return getTrendingSince(cal.getTime());
    }

    @Override
    public List<TagDto> getTrendingWeekly() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -7);
        return getTrendingSince(cal.getTime());
    }

    private List<TagDto> getTrendingSince(Date since) {
        List<Object[]> results = postTagRepository.findTrendingTags(since);

        if (results.isEmpty()) return List.of();

        List<Object[]> top10 = results.stream().limit(10).toList();

        List<String> tagIds = top10.stream()
                .map(obj -> (String) obj[0])
                .toList();

        Map<String, Tag> tagMap = tagRepository.findAllById(tagIds)
                .stream()
                .collect(Collectors.toMap(Tag::getId, t -> t));

        List<TagDto> sortedDtos = new ArrayList<>();
        for (String id : tagIds) {
            Tag t = tagMap.get(id);
            if (t != null) {
                sortedDtos.add(mapper.entityToDto(t));
            }
        }
        return sortedDtos;
    }
}