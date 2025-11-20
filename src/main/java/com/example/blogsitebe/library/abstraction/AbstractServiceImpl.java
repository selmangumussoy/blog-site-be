package com.example.blogsitebe.library.abstraction;

import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import com.example.blogsitebe.library.rest.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractServiceImpl<T extends AbstractEntity, D>
        implements AbstractService<D>{

    protected final AbstractRepository<T> repository;
    protected final AbstractEntityMapper<T, D> mapper;

    @Override
    public List<D> getAll() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

    @Override
    public Page<D> getAllList(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::entityToDto);
    }

    @Override
    public D getById(String id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_ALREADY_EXISTS, getEntityName(), id.toString()));
        return mapper.entityToDto(entity);
    }//todo .ENTITY_NOT_FOUND message code yaz

    @Override
    public D create(D dto) {
        T entity = mapper.toEntity(dto);
        return mapper.entityToDto(repository.save(entity));
    }

    @Override
    public D update(String id, D dto) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_ALREADY_EXISTS, getEntityName(), id.toString()));

        updateEntityFields(entity, dto);

        return mapper.entityToDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.findById(id)
                .orElseThrow(() -> new CoreException(MessageCodes.ENTITY_ALREADY_EXISTS, getEntityName(), id));
    }

    protected abstract String getEntityName();

    protected abstract void updateEntityFields(T entity, D dto);
}