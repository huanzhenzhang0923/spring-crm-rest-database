package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // And an exception for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerNotFoundException> handleException(CustomerNotFoundException e) {
        CustomerErrorResponse error= new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerNotFoundException> handleException(Exception e) {
        CustomerErrorResponse error= new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
    }
}