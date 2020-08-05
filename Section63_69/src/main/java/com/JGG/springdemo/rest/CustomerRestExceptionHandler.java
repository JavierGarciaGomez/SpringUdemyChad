package com.JGG.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//492,493,494
@ControllerAdvice
public class CustomerRestExceptionHandler {
    //493 Add an exceptionhandler for CustomerNotFoundExceptiion
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception){
        //create customerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //493,494 Add an exceptionhandler for other exceptions
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception){
        //create customerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
