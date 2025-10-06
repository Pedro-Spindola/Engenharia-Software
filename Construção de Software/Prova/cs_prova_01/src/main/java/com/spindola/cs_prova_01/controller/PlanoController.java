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

import com.spindola.cs_prova_01.dto.PlanoRequestDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.service.PlanoService;

@RestController
@RequestMapping("api/v2/plano")
public class PlanoController {
    @Autowired
    PlanoService planoService;

    @GetMapping("/{id}")
    public PlanoResponseDTO buscarPlanoId(@PathVariable Long id){
        return planoService.buscarPlanoId(id);
    }

    @GetMapping
    public List<PlanoResponseDTO> listarPlanos(){
        return planoService.listarPlanos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanoResponseDTO registrarPlano(@RequestBody PlanoRequestDTO planoRequestDTO){
        return planoService.registrarPlano(planoRequestDTO);
    }

    @PutMapping
    public PlanoResponseDTO atualizarPlano(@RequestBody PlanoRequestDTO planoRequestDTO){
        return planoService.atualizarPlano(planoRequestDTO);
    }
    
    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deletarPlano(@PathVariable Long id){
        return planoService.deletarPlano(id);
    }
}
