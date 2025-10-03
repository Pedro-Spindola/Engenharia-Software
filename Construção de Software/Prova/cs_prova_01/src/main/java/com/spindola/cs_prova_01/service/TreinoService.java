package com.spindola.cs_prova_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.TreinoRequestDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.repository.TreinoRepository;

@Service
public class TreinoService {
    @Autowired
    TreinoRepository treinoRepository;

    public TreinoResponseDTO buscarTreinoId(Long id){
        System.out.println("Executo buscarTreinoId no TreinoService");
        return null;
    }

    public List<TreinoResponseDTO> buscarTodos(){
        System.out.println("Executo buscarTodos no TreinoService");
        return null;
    }

    public TreinoResponseDTO registrarTreino(TreinoRequestDTO treinoRequestDTO){
        System.out.println("Executo registrarTreino no TreinoService");
        return null;
    }

    public TreinoResponseDTO atualizarTreino(TreinoRequestDTO treinoRequestDTO){
        System.out.println("Executo atualizarTreino no TreinoService");
        return null;
    }

    public Boolean deletarTreino(Long id){
        System.out.println("Executo deletarTreino no TreinoService");
        return false;
    }
}
