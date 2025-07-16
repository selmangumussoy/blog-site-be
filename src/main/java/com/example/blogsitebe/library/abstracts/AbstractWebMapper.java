package com.example.blogsitebe.library.abstracts;

public interface AbstractWebMapper<D,Req, Res> {
    D requestToDto(Req request);
    Res toResponse(D dto);
}