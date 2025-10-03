package com.spindola.cs_prova_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.PagamentoRequestDTO;
import com.spindola.cs_prova_01.dto.PagamentoResponseDTO;
import com.spindola.cs_prova_01.repository.PagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    PagamentoRepository pagamentoRepository;

    public PagamentoResponseDTO registrarPagamento(PagamentoRequestDTO pagamentoRequestDTO){
        System.out.println("Executo registrarPagamento no PagamentoService");
        return null;
    }

    public List<PagamentoResponseDTO> buscarListPagamentoAluno(Long id){
        System.out.println("Executo buscarListPagamentoAluno no PagamentoService");
        return null;
    }

}
