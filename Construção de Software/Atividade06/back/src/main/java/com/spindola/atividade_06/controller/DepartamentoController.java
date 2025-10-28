package com.spindola.atividade_06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_06.dto.DepartamentoRequestDTO;
import com.spindola.atividade_06.dto.DepartamentoResponseDTO;
import com.spindola.atividade_06.service.DepartamentoServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v2/departamento")
public class DepartamentoController {
    @Autowired
    DepartamentoServices departamentoServices;

    @GetMapping
    public List<DepartamentoResponseDTO> listarTodos(){
        return departamentoServices.listarTodos();
    }

    @GetMapping(value = "/ativos")
    public List<DepartamentoResponseDTO> listarAtivos(){
        return departamentoServices.listarAtivos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoResponseDTO novoDepartamento(@RequestBody DepartamentoRequestDTO departamentoRequestDTO) {
        return departamentoServices.criarDepartamento(departamentoRequestDTO);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDTO atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoRequestDTO departamentoRequestDTO) {
        return departamentoServices.atualizarDepartamento(id, departamentoRequestDTO);
    }

    @PatchMapping("/{id}/inativar")
    public Boolean inativarDepartamento(@PathVariable Long id){
        return departamentoServices.inativarDepartamento(id);
    }
    
}
