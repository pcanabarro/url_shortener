package com.pcanabarro.exception;

import com.pcanabarro.response.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UrlNotFoundException.class)
    public ErrorResponseDTO handleUrlNotFoundException(UrlNotFoundException e) {
        return new ErrorResponseDTO(404, e.getMessage(), "Testing");
    }
}
