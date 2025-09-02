package com.spindola.atividade_01_pp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_01_pp.model.SalaAtendimento;
import com.spindola.atividade_01_pp.services.SalaAtendimentoService;

@RestController
@RequestMapping("/sala")
public class SalaAtendimentoController {
    
    @Autowired
    private SalaAtendimentoService service;

    // Buscar a sala
    @GetMapping
    public SalaAtendimento getSala() {
        return service.getSala();
    }

    // Adicionar guichê
    @PostMapping("/guiche")
    public SalaAtendimento adicionarGuiche(@RequestParam String nomeGuiche) {
        return service.adicionarGuiche(nomeGuiche);
    }

    @DeleteMapping("/guiche/{id}")
    public String deletarGuiche(@PathVariable int id){
        System.out.println("Passando o id: " + id);
        return service.deleteGuicheId(id);
    }

    // Colocar pessoa na fila
    @PostMapping("/fila")
    public SalaAtendimento entrarNaFila(@RequestParam String pessoa) {
        return service.entrarNaFila(pessoa);
    }

    // Atender próximo
    @PutMapping("/atender")
    public String atenderProximo() {
        return service.atenderProximo();
    }

    @PostMapping("/playpause")
    public ResponseEntity<String> alternarFilaAutomatica() {
        String status = service.alternarFilaAutomatica();
        return ResponseEntity.ok(status);
    }

    @PostMapping("/atenderfila")
    public ResponseEntity<String> iniciarAtendimento() {
        String mensagem = service.iniciarAtendimento();
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/status")
    public Map<String, Boolean> getStatusFila() {
        Map<String, Boolean> status = new HashMap<>();
        status.put("filaAutomaticaAtiva", service.isFilaAutomaticaAtiva());
        status.put("atendimentoAtivo", service.isAtendendoFila());
        return status;
    }
}
