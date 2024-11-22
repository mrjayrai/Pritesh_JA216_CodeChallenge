package com.hexaware.cms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<?> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        return ex.getResponseEntity();
    }
}
