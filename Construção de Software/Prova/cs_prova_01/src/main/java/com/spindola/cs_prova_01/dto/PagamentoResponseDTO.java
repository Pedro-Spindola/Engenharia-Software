package com.spindola.cs_prova_01.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.spindola.cs_prova_01.model.enums.FormaPagamento;
import com.spindola.cs_prova_01.model.enums.StatusPagamento;

public record PagamentoResponseDTO(
    Long id,
    LocalDate data_pagamento,
    BigDecimal valor,
    StatusPagamento status,
    FormaPagamento formaPagamento,
    AlunoResponseListDTO aluno
) {}
