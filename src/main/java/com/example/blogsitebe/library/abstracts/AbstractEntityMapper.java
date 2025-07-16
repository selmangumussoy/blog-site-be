package com.example.blogsitebe.library.abstracts;

public interface AbstractEntityMapper<T, D> {
    T toEntity(D dto);
    D entityToDto(T entity);
}