package com.pcanabarro.exception;

import com.pcanabarro.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUrlNotFoundException(UrlNotFoundException e) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                "URL not found! Please check your request and try again!");

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
