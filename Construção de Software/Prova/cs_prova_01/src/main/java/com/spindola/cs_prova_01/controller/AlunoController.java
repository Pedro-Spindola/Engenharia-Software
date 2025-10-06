package com.spindola.cs_prova_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.dto.AlunoRequestAlterarDTO;
import com.spindola.cs_prova_01.dto.AlunoRequestRegistroDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseListDTO;
import com.spindola.cs_prova_01.service.AlunoService;

@RestController
@RequestMapping("api/v2/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @GetMapping
    public List<AlunoResponseListDTO> buscarTodos(){
        return alunoService.buscarTodos();
    }

    /*
    @GetMapping("/validar/entrada/{id}")
    public boolean validarEntrada(@PathVariable Long id){
        return alunoService.validarEntrada(id);
    }
    */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDTO registrarAluno(@RequestBody AlunoRequestRegistroDTO alunoRequestDTO){
        return alunoService.registrarAluno(alunoRequestDTO);
    }

    @PutMapping
    public AlunoResponseDTO alterarRegistroAluno(@RequestBody AlunoRequestAlterarDTO alunoRequestDTO){
        return alunoService.alterarAluno(alunoRequestDTO);
    }
    
}
