package com.spindola.cs_prova_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.dto.TreinoRequestDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.service.TreinoService;

@RestController
@RequestMapping("api/v2/treino")
public class TreinoController {
    @Autowired
    TreinoService treinoService;

    @GetMapping("/{id}")
    public TreinoResponseDTO buscarTreinoId(@PathVariable Long id){
        return treinoService.buscarTreinoId(id);
    }

    @GetMapping
    public List<TreinoResponseDTO> buscarTodos(){
        return treinoService.buscarTodos();
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public TreinoResponseDTO registrarTreino(@RequestBody TreinoRequestDTO treinoRequestDTO){
        return treinoService.registrarTreino(treinoRequestDTO);
    }

    @PutMapping
    public TreinoResponseDTO atualizarTreino(@RequestBody TreinoRequestDTO treinoRequestDTO){
        return treinoService.atualizarTreino(treinoRequestDTO);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deletarTreino(@PathVariable Long id){
        return treinoService.deletarTreino(id);
    }
}
