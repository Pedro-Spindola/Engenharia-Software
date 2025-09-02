package com.spindola.atividade_02_pp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_02_pp.dto.RoteadorComponentesResponseDTO;
import com.spindola.atividade_02_pp.dto.RoteadorLigacaoResponseDTO;
import com.spindola.atividade_02_pp.service.RoteadorService;

@RestController
@RequestMapping("/simulador/roteadores")
public class RoteadorController {

    @Autowired
    private RoteadorService roteadorService;

    @GetMapping("/{id}/componentes")
    public RoteadorComponentesResponseDTO componentes(@PathVariable Long id) {
        return roteadorService.listarComponentes(id);
    }

    @PostMapping("/{id}/ligar")
    public RoteadorLigacaoResponseDTO ligar(@PathVariable Long id) {
        return roteadorService.ligarRoteador(id);
    }

}