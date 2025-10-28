package com.spindola.atividade_06.dto;

public record DepartamentoResponseDTO(
    Long id,
    String nome,
    String sigla,
    Boolean ativo
) {}
