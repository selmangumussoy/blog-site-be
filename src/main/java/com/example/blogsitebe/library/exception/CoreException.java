package com.example.blogsitebe.library.exception;

import com.example.blogsitebe.library.enums.MessageCodes;
import lombok.Getter;

/**
 * CoreException is a custom runtime exception used for handling application-specific errors.
 * It includes an error code (MessageCodes) and optional arguments for message formatting.
 */

@Getter
public class CoreException extends RuntimeException {

    private final MessageCodes code;
    private final String message;
    private final Object[] args; // farklı türde hata bilgilerini tek bir parametre olarak alabilmek için

    public CoreException(MessageCodes code, Object... args) {
        this.code = code;
        this.args = args;
        this.message = null;
    }
    public CoreException(MessageCodes code, String message) {
        this.code = code;
        this.message = message;
        this.args = null;
    }
}
