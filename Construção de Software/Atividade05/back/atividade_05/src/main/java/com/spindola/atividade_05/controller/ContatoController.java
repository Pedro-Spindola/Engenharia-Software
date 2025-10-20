package com.spindola.atividade_05.controller;

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

import com.spindola.atividade_05.dto.ContatoRequestDTO;
import com.spindola.atividade_05.dto.ContatoResponse;
import com.spindola.atividade_05.service.ContatoService;

@RestController
@RequestMapping("api/v1/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<ContatoResponse> getAll() {
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ContatoResponse getById(@PathVariable Long id) {
        return contatoService.findById(id);
    }

    @PostMapping
    public ContatoResponse create(@RequestBody ContatoRequestDTO contatoRequest) {
        return contatoService.save(contatoRequest);
    }

    @PutMapping("/{id}")
    public ContatoResponse update(@PathVariable Long id, @RequestBody ContatoRequestDTO contatoRequest) {
        return this.contatoService.update(id, contatoRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return contatoService.delete(id);
    }
}
