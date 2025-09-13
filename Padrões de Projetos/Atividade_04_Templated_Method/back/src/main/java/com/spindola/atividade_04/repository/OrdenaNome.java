package com.spindola.atividade_04.repository;

import java.util.Comparator;
import java.util.List;

import com.spindola.atividade_04.model.Aluno;

public class OrdenaNome extends AlunoRepositoryTemplateMethod {
    @Override
    public List<Aluno> ordenacao(List<Aluno> alunos) {
        alunos.sort(Comparator.comparing(Aluno::getNome));
        return alunos;
    }
}
