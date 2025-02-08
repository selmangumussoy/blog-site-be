package com.example.blogsitebe.library.enums;

import lombok.Getter;

@Getter
public enum MessageCodes {
    SUCCESS("200", "general.success"),
    FAIL("500", "general.fail");

    private final String code;
    private final String message;

    MessageCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
