package com.springboot.webservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                          WebRequest webRequest){
            
            ErrorDetails errorDetails = new ErrorDetails(
               LocalDateTime.now(),
               exception.getMessage(),
               webRequest.getDescription(false),
               errorCode:"student not found"
            );
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);  
   }                                                                

   @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException exception,
                                                                          WebRequest webRequest){
            
            ErrorDetails errorDetails = new ErrorDetails(
               LocalDateTime.now(),
               exception.getMessage(),
               webRequest.getDescription(false),
               errorCode:"email already exist"
            );
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);  
   } 
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                                          WebRequest webRequest){
            
            ErrorDetails errorDetails = new ErrorDetails(
               LocalDateTime.now(),
               exception.getMessage(),
               webRequest.getDescription(false),
               errorCode:"email already exist"
            );
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);  
   }         
   }
    

