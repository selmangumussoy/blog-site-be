package com.example.blogsitebe.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Generic response model for paginated data.
 * Uses a generic type parameter <T> to support various data types.
 * Wraps data in a Page<T> structure to handle pagination efficiently.
 * Implements a custom toString() method for better readability.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T>{
    private Page<T> items = Page.empty();


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("pageItems: ");
        if(items!=null && !items.isEmpty()){
            items.forEach(builder::append);
        }
        return builder.toString();
    }
}
