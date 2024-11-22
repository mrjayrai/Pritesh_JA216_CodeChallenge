package com.hexaware.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PlayerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final ResponseEntity<?> response;

    public PlayerNotFoundException(String message) {
        super(message);
        this.response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(message, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> getResponseEntity() {
        return response;
    }

    // Inner class for custom error response structure
    public static class ErrorResponse {
        private String message;
        private HttpStatus status;

        public ErrorResponse(String message, HttpStatus status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getStatus() {
            return status;
        }
    }
}
