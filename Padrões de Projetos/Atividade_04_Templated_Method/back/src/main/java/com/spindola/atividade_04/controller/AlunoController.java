package com.spindola.atividade_04.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_04.model.Aluno;
import com.spindola.atividade_04.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    // Constructor
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/ordenarCursoEnfase")
    public List<Aluno> getOrdenarCursoEnfase() throws IOException{
        return alunoService.ordenarCursoEnfase();
    }

    @GetMapping("/ordenarCursoNome")
    public List<Aluno> getOrdenarCursoNome() throws IOException{
        return alunoService.ordenarCursoNome();
    }

    @GetMapping("/ordenarEnfaseCurso")
    public List<Aluno> getOrdenarEnfaseCurso() throws IOException{
        return alunoService.ordenarEnfaseCurso();
    }

    @GetMapping("/ordenarEnfaseNome")
    public List<Aluno> getOrdenarEnfaseNome() throws IOException{
        return alunoService.ordenarEnfaseNome();
    }

    @GetMapping("/ordenarNome")
    public List<Aluno> getOrdenarNome() throws IOException{
        return alunoService.ordenarNome();
    }

    @GetMapping("/ordenarSitucaoNome")
    public List<Aluno> getOrdenarSituacaoNome() throws IOException{
        return alunoService.ordenarSituacaoNome();
    }

    @GetMapping("/ordenarSobrenome")
    public List<Aluno> getOrdenarSobrenome() throws IOException{
        return alunoService.ordenarSobrenome();
    }
}
