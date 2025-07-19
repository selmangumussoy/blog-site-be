package com.example.blogsitebe.library.abstraction;

public interface AbstractEntityMapper<T, D> {
    T toEntity(D dto);
    D entityToDto(T entity);
}