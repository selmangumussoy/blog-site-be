package com.example.blogsitebe.library.exception;

import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.rest.MetaResponse;
import com.example.blogsitebe.library.rest.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
/**
 * GlobalExceptionHandler is responsible for handling exceptions globally across the application.
 * It ensures that exceptions are properly logged and transformed into meaningful API responses.
 *
 * - Uses @RestControllerAdvice to provide centralized exception handling for all REST controllers.
 * - Uses @Slf4j to enable logging of error messages for debugging and monitoring.
 * - Extends BaseExceptionHandler to inherit common exception handling functionality.
 *
 * This class primarily handles CoreException and ensures that error messages are retrieved based on
 * the user's locale, providing internationalization support.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseExceptionHandler {

    MessageSource messageSource;
    public GlobalExceptionHandler(MessageSource messageSource) {this.messageSource = messageSource;}

    @ExceptionHandler(CoreException.class)
    public Response<MetaResponse> handleCoreException(CoreException coreException , Locale locale) {
        MessageCodes messageCodes = coreException.getCode();

        String message = StringUtils
                .hasLength(coreException.getMessage())
                ? coreException.getMessage()
                : messageSource.getMessage(messageCodes.getMessage(), coreException.getArgs(), locale);

        String sb = "[CoreException] messageCode: " + messageCodes.getCode() + ", message: " + message;
        log.error(sb, coreException);

        return respond(MetaResponse.of(messageCodes.getCode(), message));
    }
}
