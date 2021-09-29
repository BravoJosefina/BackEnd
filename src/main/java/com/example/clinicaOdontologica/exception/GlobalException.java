package com.example.clinicaOdontologica.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    private static final Logger logger = Logger.getLogger(GlobalException.class);

    @ExceptionHandler( { ResourceNotFoundException.class } )
    public ResponseEntity<String> processResourceNotFound( ResourceNotFoundException exception) {
        logger.error("ResourceNotFound",exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler( {BadRequestException.class } )
    public ResponseEntity<String> processBadRequest( BadRequestException exception) {
        logger.error("BadRequest",exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}