package com.springrest.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCustomerException(CustomerNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PolicyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePolicyException(PolicyNotFoundException ex) {
        return ex.getMessage();
    }
}