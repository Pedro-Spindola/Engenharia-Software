package com.spindola.atividade_05.dto;

public record ContatoResponse(
    Long id,
    String nome,
    String email,
    String telefone
) {
}