package com.spindola.atividade_06.dto;

public record DepartamentoRequestDTO(
    Long id,
    String nome,
    String sigla,
    Boolean ativo
) {}