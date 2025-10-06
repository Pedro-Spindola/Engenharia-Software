package com.spindola.cs_prova_01.dto;

import java.time.LocalDate;

public record AlunoRequestRegistroDTO(
    String nome,
    String cpf,
    LocalDate data_nascimento
) {}
