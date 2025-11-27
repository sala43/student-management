package com.resume.student.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
@Data
public class ValidationErrorResponse {
    private LocalDateTime timestamp; // When the error occurred
    private String message;          // A general message like "Validation Failed"
    private Map<String, String> errors;

    public ValidationErrorResponse() {
    }

    public ValidationErrorResponse(LocalDateTime timestamp, String message, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }
}
