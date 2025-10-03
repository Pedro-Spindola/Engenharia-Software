package com.spindola.cs_prova_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.dto.TreinoRequestDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.service.TreinoService;

@RestController
@RequestMapping("api/v1/treino")
public class TreinoController {
    @Autowired
    TreinoService treinoService;

    @GetMapping("/{id}")
    public TreinoResponseDTO buscarTreinoId(@PathVariable Long id){
        System.out.println("Executo buscarTreinoId no TreinoController");
        return treinoService.buscarTreinoId(id);
    }

    @PostMapping
    public List<TreinoResponseDTO> buscarTodos(){
        System.out.println("Executo buscarTodos no TreinoController");
        return treinoService.buscarTodos();
    }

    @PostMapping 
    public TreinoResponseDTO registrarTreino(@RequestBody TreinoRequestDTO treinoRequestDTO){
        System.out.println("Executo registrarTreino no TreinoController");
        return treinoService.registrarTreino(treinoRequestDTO);
    }

    @PutMapping
    public TreinoResponseDTO atualizarTreino(@RequestBody TreinoRequestDTO treinoRequestDTO){
        System.out.println("Executo atualizarTreino no TreinoController");
        return treinoService.atualizarTreino(treinoRequestDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public Boolean deletarTreino(@PathVariable Long id){
        System.out.println("Executo deletarTreino no TreinoController");
        return treinoService.deletarTreino(id);
    }
}
