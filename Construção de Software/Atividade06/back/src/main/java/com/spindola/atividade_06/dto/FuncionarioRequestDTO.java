package com.spindola.atividade_06.dto;

import java.math.BigDecimal;

public record FuncionarioRequestDTO(
    Long id,
    String nome,
    String email,
    String cargo,
    BigDecimal salario,
    Boolean status
) {
    
}