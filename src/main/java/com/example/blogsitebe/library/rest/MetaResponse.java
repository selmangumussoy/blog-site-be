package com.example.blogsitebe.library.rest;

import com.example.blogsitebe.library.enums.MessageCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * MetaResponse model class that represents a standardized response structure.
 * It includes a description and a response code.
 * Provides utility methods for success and failure responses.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MetaResponse {
    public String description;
    public String code;

    public static MetaResponse of(String description, String code) {
        return new MetaResponse(description, code);
    }

    public static MetaResponse success() {
        return new MetaResponse(MessageCodes.SUCCESS.getCode(), "Success");
    }

    public static MetaResponse fail(String description) {
        return new MetaResponse(MessageCodes.FAIL.getCode(), description);
    }

}
