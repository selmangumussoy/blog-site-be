package com.example.blogsitebe.library.abstracts;

import java.util.List;

public interface AbstractService<D> {
    List<D> getAll();
    D getById(String id);
    D create(D dto);
    D update(String id, D dto);
    void delete(String id);
}
