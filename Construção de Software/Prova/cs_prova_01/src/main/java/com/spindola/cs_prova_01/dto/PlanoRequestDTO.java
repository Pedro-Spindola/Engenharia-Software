package com.spindola.cs_prova_01.dto;

import java.math.BigDecimal;

public record PlanoRequestDTO(
    Long id,
    String nome,
    String descricao,
    BigDecimal valor_mensal
) {}
