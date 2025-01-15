package com.bnb3.exception;

import com.bnb3.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleNoResourceFoundException
            (Exception e, WebRequest request) {

        ErrorDetails err = new ErrorDetails(new Date(), e.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
