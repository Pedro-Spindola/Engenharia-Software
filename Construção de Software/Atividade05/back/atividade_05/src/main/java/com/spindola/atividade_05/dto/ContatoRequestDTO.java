package com.spindola.atividade_05.dto;

public record ContatoRequestDTO(
    Long id,
    String nome,
    String email,
    String telefone
) {
}