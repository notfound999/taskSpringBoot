package com.example.demo.domain.controller;

import com.example.demo.domain.dto.ErrorRespond;
import com.example.demo.domain.entities.TaskList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorRespond> handleExceptions(
            RuntimeException ex , WebRequest webRequest
    ) {
        ErrorRespond errorRespond = new ErrorRespond(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorRespond, HttpStatus.BAD_REQUEST);
    }
}
