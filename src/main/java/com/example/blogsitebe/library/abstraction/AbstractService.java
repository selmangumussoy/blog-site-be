package com.example.blogsitebe.library.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AbstractService<D> {
    List<D> getAll();
    Page<D> getAllList(Pageable pageable);
    D getById(String id);
    D create(D dto);
    D update(String id, D dto);
    void delete(String id);
}
