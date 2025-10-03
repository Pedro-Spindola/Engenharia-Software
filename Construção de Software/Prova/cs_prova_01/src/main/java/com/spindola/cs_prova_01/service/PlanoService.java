package com.spindola.cs_prova_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.PlanoRequestDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.repository.PlanoRepository;

@Service
public class PlanoService {
    @Autowired
    PlanoRepository planoRepository;

    public PlanoResponseDTO buscarPlanoId(Long id){
        System.out.println("Executo buscarPlanoId no PlanoService");
        return null;
    }

    public List<PlanoResponseDTO> listarPlanos(){
        System.out.println("Executo listarPlanos no PlanoService");
        return null;
    } 

    public PlanoResponseDTO registrarPlano(PlanoRequestDTO planoRequestDTO){
        System.out.println("Executo registrarPlano no PlanoService");
        return null;
    }

    public PlanoResponseDTO atualizarPlano(PlanoRequestDTO planoRequestDTO){
        System.out.println("Executo atualizarPlano no PlanoService");
        return null;
    }

    public boolean deletarPlano(Long id){
        System.out.println("Executo deletarPlano no PlanoService");
        return false;
    }
}
