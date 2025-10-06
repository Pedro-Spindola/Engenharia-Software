package com.spindola.cs_prova_01.mapper;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spindola.cs_prova_01.dto.AlunoResponseListDTO;
import com.spindola.cs_prova_01.dto.PagamentoRequestDTO;
import com.spindola.cs_prova_01.dto.PagamentoResponseDTO;
import com.spindola.cs_prova_01.model.Aluno;
import com.spindola.cs_prova_01.model.Pagamento;
import com.spindola.cs_prova_01.repository.AlunoRepository;

@Component
public class PagamentoMapper {
    @Autowired
    AlunoRepository alunoRepository;

    public Pagamento toEntity(PagamentoRequestDTO dto, Aluno aluno){ 
        Pagamento pagamento = new Pagamento();
        pagamento.setValorPago(dto.valor());
        pagamento.setFormaPagamento(dto.formaPagamento());
        pagamento.setAluno(aluno); 
        pagamento.setData_pagamento(LocalDate.now());
        return pagamento;
    }

    public PagamentoResponseDTO toResponseDTO(Pagamento pagamento){
        Aluno aluno = pagamento.getAluno();

        AlunoResponseListDTO alunoResponseListDTO = new AlunoResponseListDTO(
            aluno.getId(),
            aluno.getNome()
        );

        PagamentoResponseDTO pagamentoResponseDTO = new PagamentoResponseDTO(
            pagamento.getId(),
            pagamento.getData_pagamento(),
            pagamento.getValorPago(),
            pagamento.getStatus(),
            pagamento.getFormaPagamento(),
            alunoResponseListDTO
        );
        return pagamentoResponseDTO;
    }
}
