package com.spindola.cs_prova_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.cs_prova_01.service.AlunoService;

@RestController
@RequestMapping("api/v1/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    /* 
    
    FAZER ESSE PADRÃO

    @GetMapping("/{id}")
    public Produto findById(Long id){
        return produtoService.findById(id);
    }

    @GetMapping
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PostMapping
    public Produto save(@RequestBody Produto usuario){
        return produtoService.save(usuario);
    }

    @PutMapping
    public Produto update(@RequestBody Produto usuario){
        return produtoService.update(usuario);
    }

    @DeleteMapping
    public void delete(@RequestBody Produto usuario){
        produtoService.delete(usuario);
    } 
    */
    
}
