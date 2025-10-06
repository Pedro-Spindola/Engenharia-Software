package com.spindola.cs_prova_01.dto;

import java.math.BigDecimal;

import com.spindola.cs_prova_01.model.enums.FormaPagamento;

public record PagamentoRequestDTO(
    Long id,
    BigDecimal valor,
    FormaPagamento formaPagamento,
    Long aluno
) {}
