package com.lucas.taskmanager.resources;

import com.lucas.taskmanager.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException ex, HttpServletRequest req){
        StandardError error = new StandardError(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

}
