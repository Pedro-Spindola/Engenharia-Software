package com.spindola.cs_prova_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.dto.AlunoRequestDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseDTO;
import com.spindola.cs_prova_01.service.AlunoService;

@RestController
@RequestMapping("api/v1/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @GetMapping
    public List<AlunoResponseDTO> buscarTodos(){
        return alunoService.buscarTodos();
    }

    @PostMapping
    public AlunoResponseDTO registrarAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        return alunoService.registrarAluno(alunoRequestDTO);
    }

    @PutMapping
    public AlunoResponseDTO alterarRegistroAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        return alunoService.alterarRegistroAluno(alunoRequestDTO);
    }
    
}
