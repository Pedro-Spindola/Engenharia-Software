package com.spindola.cs_prova_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.dto.PagamentoRequestDTO;
import com.spindola.cs_prova_01.dto.PagamentoResponseDTO;
import com.spindola.cs_prova_01.service.PagamentoService;

@RestController
@RequestMapping("api/v2/pagamento")
public class PagamentoController {
    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public List<PagamentoResponseDTO> buscarPorIdAluno(@PathVariable Long id){
        return pagamentoService.buscarListPagamentoAluno(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean registrarPagamento(@RequestBody PagamentoRequestDTO pagamentoRequestDTO){
        return pagamentoService.registrarPagamento(pagamentoRequestDTO);
    }
}
