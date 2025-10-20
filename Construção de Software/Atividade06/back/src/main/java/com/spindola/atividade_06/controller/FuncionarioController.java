package com.spindola.atividade_06.controller;

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

import com.spindola.atividade_06.dto.FuncionarioRequestDTO;
import com.spindola.atividade_06.dto.FuncionarioResponseDTO;
import com.spindola.atividade_06.service.FuncionarioServices;

@RestController
@RequestMapping("api/v1/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioServices funcionarioServices;

    @GetMapping
    public List<FuncionarioResponseDTO> listarFuncionarios() {
        return funcionarioServices.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioResponseDTO obterFuncionarioId(@PathVariable Long id) {
        return funcionarioServices.obterFuncionarioId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioResponseDTO cadastrarFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        return funcionarioServices.cadastrarFuncionario(funcionarioRequestDTO);
    }

    @PutMapping
    public FuncionarioResponseDTO editarFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        return funcionarioServices.editarFuncionario(funcionarioRequestDTO);
    }

    @PutMapping("/{id}")
    public Boolean inativarFuncionario(@PathVariable Long id) {
        return funcionarioServices.inativarFuncionario(id);
    }
}
