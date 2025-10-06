package com.spindola.cs_prova_01.dto;

import com.spindola.cs_prova_01.model.enums.NivelTreino;

public record TreinoResponseDTO(
    Long id,
    String nome,
    String descricao,
    NivelTreino nivelTreino
) {}
