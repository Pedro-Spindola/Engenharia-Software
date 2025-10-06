package com.spindola.cs_prova_01.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.PlanoRequestDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.mapper.PlanoMapper;
import com.spindola.cs_prova_01.model.Plano;
import com.spindola.cs_prova_01.repository.PlanoRepository;

@Service
public class PlanoService {
    @Autowired
    PlanoRepository planoRepository;
    @Autowired
    PlanoMapper planoMapper;

    public PlanoResponseDTO buscarPlanoId(Long id){
         Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Plano com ID " + id + " não encontrado."));
        return planoMapper.toResponseDTO(plano);
    }

    public List<PlanoResponseDTO> listarPlanos(){
        return planoRepository.findAll().stream()
                .map(planoMapper::toResponseDTO)
                .toList();
    } 

    public PlanoResponseDTO registrarPlano(PlanoRequestDTO planoRequestDTO){
        if (planoRequestDTO.nome() == null || planoRequestDTO.nome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do plano é obrigatório.");
        }
        if (planoRequestDTO.descricao() == null || planoRequestDTO.descricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do plano é obrigatória.");
        }
        if (planoRequestDTO.valor_mensal() == null || planoRequestDTO.valor_mensal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor mensal do plano é obrigatório e deve ser positivo.");
        }

        Plano plano = planoMapper.toEntity(planoRequestDTO);
        plano.setId(null); 
        planoRepository.save(plano);
        return planoMapper.toResponseDTO(plano);
    }

    public PlanoResponseDTO atualizarPlano(PlanoRequestDTO planoRequestDTO){
        if (planoRequestDTO.id() == null) {
            throw new IllegalArgumentException("O ID do plano é obrigatório para a atualização.");
        }
        
        if (planoRequestDTO.nome() == null || planoRequestDTO.nome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do plano é obrigatório.");
        }
        if (planoRequestDTO.descricao() == null || planoRequestDTO.descricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do plano é obrigatória.");
        }
        if (planoRequestDTO.valor_mensal() == null || planoRequestDTO.valor_mensal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor mensal do plano é obrigatório e deve ser positivo.");
        }

        planoRepository.findById(planoRequestDTO.id())
                        .orElseThrow(() -> new NoSuchElementException("Plano com ID " + planoRequestDTO.id() + " não encontrado para atualização."));
        
        Plano plano = planoMapper.toEntity(planoRequestDTO);
        planoRepository.save(plano);
        return planoMapper.toResponseDTO(plano);
    }

    public boolean deletarPlano(Long id){
        Plano planoExistente = planoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Plano com ID " + id + " não encontrado para exclusão."));
        
        planoRepository.delete(planoExistente);
        
        return true;
    }
}
