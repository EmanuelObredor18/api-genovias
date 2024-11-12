package com.globalvia.genovias.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.exceptions.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejar las excepciones de validaciones (Jakarta Validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorResponse.put(fieldName, errorMessage);
        });
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Not Found");
        errorResponse.put("details", ex.getMessage());
        return ResponseEntity.status(404).body(errorResponse);  // Directamente retornar el mapa sin manipular el ResponseEntity
    }

    @ExceptionHandler(EntityFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> handleEntityFoundException(EntityFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "CONFLICT");
        errorResponse.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);  // Directamente retornar el mapa sin manipular el ResponseEntity
    }

}
