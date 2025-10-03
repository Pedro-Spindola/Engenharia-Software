package com.spindola.cs_prova_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.AlunoRequestDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseDTO;
import com.spindola.cs_prova_01.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public AlunoResponseDTO buscarPorId(Long id){
        System.out.println("Executo buscarPorId no AlunoService");
        return null;
    }

    public List<AlunoResponseDTO> buscarTodos(){
        System.out.println("Executo buscarTodos no AlunoService");
        return null;
    }

    public AlunoResponseDTO registrarAluno(AlunoRequestDTO alunoRequestDTO){
        System.out.println("Executo registrarAluno no AlunoService");
        return null;
    }

    public AlunoResponseDTO alterarRegistroAluno(AlunoRequestDTO alunoRequestDTO){
        System.out.println("Executo alterarRegistroAluno no AlunoService");
        return null;
    }

    public Boolean desativarAluno(Long id){
        System.out.println("Executo desativarAluno no AlunoService");
        return null;
    }
}
