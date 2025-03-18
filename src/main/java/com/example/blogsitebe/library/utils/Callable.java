package com.example.blogsitebe.library.utils;

@FunctionalInterface
public interface Callable<T, R> {
    T call(R r);
}