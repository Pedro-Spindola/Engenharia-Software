package com.spindola.cs_prova_01.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.PagamentoRequestDTO;
import com.spindola.cs_prova_01.dto.PagamentoResponseDTO;
import com.spindola.cs_prova_01.mapper.PagamentoMapper;
import com.spindola.cs_prova_01.model.Aluno;
import com.spindola.cs_prova_01.model.Pagamento;
import com.spindola.cs_prova_01.model.enums.StatusPagamento;
import com.spindola.cs_prova_01.repository.AlunoRepository;
import com.spindola.cs_prova_01.repository.PagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    PagamentoMapper pagamentoMapper;
    @Autowired
    AlunoRepository alunoRepository;

    public Boolean registrarPagamento(PagamentoRequestDTO pagamentoRequestDTO){
        if (pagamentoRequestDTO.valor() == null || pagamentoRequestDTO.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do pagamento é obrigatório e deve ser positivo.");
        }
        if (pagamentoRequestDTO.formaPagamento() == null) {
            throw new IllegalArgumentException("A forma de pagamento é obrigatória.");
        }
        if (pagamentoRequestDTO.aluno() == null) {
            throw new IllegalArgumentException("O ID do aluno é obrigatório para registrar o pagamento.");
        }

        Aluno aluno = alunoRepository.findById(pagamentoRequestDTO.aluno())
            .orElseThrow(() -> new NoSuchElementException("Aluno com ID " + pagamentoRequestDTO.aluno() + " não encontrado para registrar o pagamento."));
            
        Pagamento pagamento = pagamentoMapper.toEntity(pagamentoRequestDTO, aluno);
        
        pagamento.setId(null); 
        pagamento.setStatus(StatusPagamento.PAGO);
        
        pagamentoRepository.save(pagamento);
        return true;
    }

    public List<PagamentoResponseDTO> buscarListPagamentoAluno(Long id){
        List<Pagamento> pagamentos = pagamentoRepository.findByAlunoId(id);

        return pagamentos.stream()
            .map(pagamentoMapper::toResponseDTO)
            .toList();
    }

}
