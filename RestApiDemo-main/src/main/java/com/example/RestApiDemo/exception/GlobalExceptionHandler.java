package com.example.RestApiDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.RestApiDemo.dto.ResponseDTO;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(ex.getMessage(), "error", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
