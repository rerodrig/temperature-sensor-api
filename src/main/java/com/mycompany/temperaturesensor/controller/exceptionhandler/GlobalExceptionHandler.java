package com.mycompany.temperaturesensor.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorMessage> handleWebExchangeBindException(WebExchangeBindException e) {

        List<String> errors = e.getBindingResult().getAllErrors()
                .stream()
                .map(this::buildValidationError)
                .collect(Collectors.toList());

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis(), e.getReason(), errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }

    private String buildValidationError(ObjectError e) {
        if (e instanceof FieldError) {
            FieldError fieldError = (FieldError) e;
            return String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());
        }
        return e.getDefaultMessage();
    }

}
