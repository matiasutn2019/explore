package com.disney.explore.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(SendEmailException.class)
    public ResponseEntity<?> handleSendEmailException(HttpServletRequest request,
        SendEmailException e) {
        return ResponseEntity.badRequest()
            .body(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<?> handleUserAlreadyRegisteredException(HttpServletRequest request,
        UserAlreadyRegisteredException e) {
        return ResponseEntity.badRequest()
            .body(HttpStatus.BAD_REQUEST);
    }

}
