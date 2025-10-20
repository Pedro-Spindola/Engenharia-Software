package com.spindola.atividade_05.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ContatoException.class)
    public ResponseEntity<ErroResponse> handleContatoException(ContatoException ce){
        ErroResponse error = new ErroResponse(
            HttpStatus.NOT_FOUND.value(),
            ce.getMessage(),
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
