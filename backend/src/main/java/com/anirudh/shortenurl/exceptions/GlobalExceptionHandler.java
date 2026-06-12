package com.anirudh.shortenurl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<String> handleInvalidURLException(InvalidURLException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(URLExpiredException.class)
    public ResponseEntity<String> handleURLExpiredException(URLExpiredException exception){
        return ResponseEntity.status(HttpStatus.GONE)
                .body(exception.getMessage());
    }
}
