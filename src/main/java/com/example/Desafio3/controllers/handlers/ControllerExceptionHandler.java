package com.example.Desafio3.controllers.handlers;

import com.example.Desafio3.dto.CustomError;
import com.example.Desafio3.dto.ValidationError;
import com.example.Desafio3.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler( ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound( ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());


        return ResponseEntity.status(status).body(err);
    }
}
