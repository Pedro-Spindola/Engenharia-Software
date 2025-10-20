package com.spindola.atividade_06.exception;

public class EmailException extends RuntimeException {
    public EmailException(String messagem){
        super("Email " + messagem + " já está cadastrado.");
    }
}
