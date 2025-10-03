package com.senai.spindola.cs_atividade04.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.spindola.cs_atividade04.dto.VeiculoRequestDTO;
import com.senai.spindola.cs_atividade04.model.Veiculo;
import com.senai.spindola.cs_atividade04.service.VeiculoService;

@RestController
@RequestMapping("api/v1/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> buscarTodos(){
        return this.service.buscarTodos();
    }

    @GetMapping(value = "/ativos")
    public List<Veiculo> buscarAtivos(){
        return this.service.listarEstacionados();
    }

    @GetMapping(value = "/{placa}")
    public Veiculo findByPlaca(@PathVariable String placa){
        return this.service.findByPlaca(placa);
    }

    @GetMapping("/faturamento/{data}")
    public ResponseEntity<String> getFaturamento(
        @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDateTime data) {
        return ResponseEntity.ok(service.faturamentoDia(data));
    }

    @PostMapping(value = "/entrada")
    public Veiculo salvaEntrada(@RequestBody VeiculoRequestDTO veiculoRequestDTO){
        return this.service.registrarEntrada(veiculoRequestDTO);
    }

    @PutMapping(value = "/saida/{id}")
    public Veiculo saidaVeiculo(long id){
        return this.service.registrarSaida(id);
    }
}
