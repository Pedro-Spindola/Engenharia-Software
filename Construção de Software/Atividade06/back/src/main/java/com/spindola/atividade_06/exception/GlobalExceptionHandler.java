package com.spindola.atividade_06.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FuncionarioException.class)
    public ResponseEntity<ErroResponse> handleFuncionarioException(FuncionarioException e){
        ErroResponse error = new ErroResponse(
            HttpStatus.NOT_FOUND.value(),
            e.getMessage(),
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErroResponse> handleEmailException(EmailException e){
        ErroResponse error = new ErroResponse(
            HttpStatus.CONFLICT.value(),
            e.getMessage(),
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
