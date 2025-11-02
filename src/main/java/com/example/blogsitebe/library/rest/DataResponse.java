package com.example.blogsitebe.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;

import java.util.List;

/**
 * Generic response model for handling lists of data items.
 * Uses a generic type parameter <T> to support various data types.
 * Implements a custom toString() method for better readability.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse<T> {
    private List<T> items = List.of();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("dataItems: ");
        if (items != null && !items.isEmpty()) {
            items.forEach(builder::append);
        }
        return builder.toString();
    }
}
