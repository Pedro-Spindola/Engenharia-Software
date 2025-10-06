package com.spindola.cs_prova_01.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.TreinoRequestDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.mapper.TreinoMapper;
import com.spindola.cs_prova_01.model.Treino;
import com.spindola.cs_prova_01.repository.TreinoRepository;

@Service
public class TreinoService {
    @Autowired
    TreinoRepository treinoRepository;
    @Autowired
    TreinoMapper treinoMapper;

    public TreinoResponseDTO buscarTreinoId(Long id){
        Treino treino = treinoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Treino com ID " + id + " não encontrado."));
        
        return treinoMapper.toResponseDTO(treino);
    }

    public List<TreinoResponseDTO> buscarTodos(){
        return treinoRepository.findAll().stream()
                .map(treinoMapper::toResponseDTO)
                .toList();
    }

    public TreinoResponseDTO registrarTreino(TreinoRequestDTO treinoRequestDTO){
        if (treinoRequestDTO.nome() == null || treinoRequestDTO.nome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do treino é obrigatório.");
        }
        if (treinoRequestDTO.descricao() == null || treinoRequestDTO.descricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do treino é obrigatória.");
        }
        if (treinoRequestDTO.nivelTreino() == null) {
            throw new IllegalArgumentException("O nível do treino é obrigatório.");
        }

        Treino treino = treinoMapper.toEntity(treinoRequestDTO);
        treino.setId(null);
        treinoRepository.save(treino);

        return treinoMapper.toResponseDTO(treino);
    }

    public TreinoResponseDTO atualizarTreino(TreinoRequestDTO treinoRequestDTO){
        if (treinoRequestDTO.id() == null) {
            throw new IllegalArgumentException("O ID do treino é obrigatório para a atualização.");
        }

        if (treinoRequestDTO.nome() == null || treinoRequestDTO.nome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do treino é obrigatório.");
        }
        if (treinoRequestDTO.descricao() == null || treinoRequestDTO.descricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do treino é obrigatória.");
        }
        if (treinoRequestDTO.nivelTreino() == null) {
            throw new IllegalArgumentException("O nível do treino é obrigatório.");
        }

        treinoRepository.findById(treinoRequestDTO.id())
                .orElseThrow(() -> new NoSuchElementException("Treino com ID " + treinoRequestDTO.id() + " não encontrado para atualização."));
            
        Treino treino = treinoMapper.toEntity(treinoRequestDTO);
        treinoRepository.save(treino);
        return treinoMapper.toResponseDTO(treino);
    }

    public Boolean deletarTreino(Long id){
        Treino treinoExistente = treinoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Treino com ID " + id + " não encontrado para exclusão."));
        
        treinoRepository.delete(treinoExistente);
        return true;
    }
}
