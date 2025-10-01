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
        return null;
    }

    public List<PlanoResponseDTO> listarPlanos(){
        return null;
    } 

    public PlanoResponseDTO registrarPlano(PlanoRequestDTO planoRequestDTO){
        return null;
    }

    public PlanoResponseDTO atualizarPlano(PlanoRequestDTO planoRequestDTO){
        return null;
    }

    public boolean deletarPlano(Long id){
        return false;
    }
}
