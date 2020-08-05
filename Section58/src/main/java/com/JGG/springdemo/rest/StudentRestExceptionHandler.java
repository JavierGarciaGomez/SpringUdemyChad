package com.JGG.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//478
@ControllerAdvice
public class StudentRestExceptionHandler {
    //Add exception handling code
    
    // 474. Add an exceptionhandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException studentNotFoundException){
        //474 create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        // return responseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
    //476 Add another exceptionHandler for other exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception e){
        //474 create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value()); // Bad request
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        // return responseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
