package com.example.blogsitebe.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Utility class for building standardized API responses.
 * Provides static methods to create `Response<T>` objects from different data structures.
 */

public class ResponseBuilder {

    public ResponseBuilder() {
    }

    public static <T> Response<DataResponse<T>> build(List<T> items) {
        return new Response<>(new DataResponse<>(items));
    }

    public static <T> Response<PageResponse<T>> build(Page<T> items) {
        return new Response<>(new PageResponse<>(items));
    }

    public static <T> Response<T> build(T item) {
        return new Response<>(item);
    }

    public static Response<MetaResponse> build(MetaResponse metaResponse) {
        return new Response<>(metaResponse);
    }
}
