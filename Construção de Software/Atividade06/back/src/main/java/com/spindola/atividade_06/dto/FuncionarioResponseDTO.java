package com.spindola.atividade_06.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FuncionarioResponseDTO(
    Long id,
    String nome,
    String email,
    String cargo,
    BigDecimal salario,
    LocalDate dataAdmissao,
    Boolean status,
    DepartamentoResponseDTO departamentoResponseDTO
){
}
