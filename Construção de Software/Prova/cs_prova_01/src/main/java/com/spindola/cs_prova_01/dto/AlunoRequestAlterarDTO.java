package com.spindola.cs_prova_01.dto;

import java.time.LocalDate;
import java.util.List;

import com.spindola.cs_prova_01.model.enums.StatusAluno;

public record AlunoRequestAlterarDTO(
    Long id,
    String nome,
    String cpf,
    LocalDate data_nascimento,
    StatusAluno statusAluno,
    Long plano_id,
    List<Long> treinos
) {}
