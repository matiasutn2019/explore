package com.disney.explore.exception;

import com.disney.explore.domain.response.ErrorResponse;
import java.io.IOException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(HttpServletRequest request,
        EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(buildResponse(e, HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<?> handleUserAlreadyRegisteredException(HttpServletRequest request,
        UserAlreadyRegisteredException e) {
        return ResponseEntity.badRequest()
            .body(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(HttpServletRequest request,
        BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(buildResponse(e, HttpStatus.UNAUTHORIZED));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception e) {
        return ResponseEntity.internalServerError()
            .body(buildResponse(e, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException(HttpServletRequest request, IOException e) {
        return ResponseEntity.badRequest()
            .body(buildResponse(e, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(HttpServletRequest request, Exception e) {
        return ResponseEntity.internalServerError()
            .body(buildResponse(e, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ErrorResponse buildResponse(Exception e, HttpStatus httpStatus) {
        return new ErrorResponse(e, httpStatus.value());
    }

    private ErrorResponse buildResponse(String message, HttpStatus httpStatus) {
        return new ErrorResponse(message, httpStatus.value());
    }

}
