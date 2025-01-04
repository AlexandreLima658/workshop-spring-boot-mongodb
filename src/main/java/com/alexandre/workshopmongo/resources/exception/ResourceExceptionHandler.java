package com.alexandre.workshopmongo.resources.exception;


import com.alexandre.workshopmongo.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> NotFound(
            NotFoundException e,
            HttpServletRequest request
    ) {

        final HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(
                e.getMessage()
        );

        return ResponseEntity.status(status).body(err);

    }
}
