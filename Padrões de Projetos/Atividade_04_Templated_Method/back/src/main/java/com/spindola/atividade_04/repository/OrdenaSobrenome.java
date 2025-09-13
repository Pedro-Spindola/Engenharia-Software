package com.spindola.atividade_04.repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.spindola.atividade_04.model.Aluno;

public class OrdenaSobrenome extends AlunoRepositoryTemplateMethod {
    @Override
    public List<Aluno> ordenacao(List<Aluno> alunos) {
        for(Aluno aluno : alunos){
            aluno.setNome(converterNomePadraoAmericano(aluno.getNome()));
        }
        alunos.sort(Comparator.comparing(Aluno::getNome));
        return alunos;
    }

    public String converterNomePadraoAmericano(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            return nomeCompleto;
        }
        String[] partesDoNome = nomeCompleto.split(" ");
        if (partesDoNome.length < 2) {
            return nomeCompleto;
        }
        String sobrenome = partesDoNome[partesDoNome.length - 1];
        String primeiroNome = Arrays.stream(partesDoNome).limit(partesDoNome.length - 1).collect(Collectors.joining(" "));
        return sobrenome + " " + primeiroNome;
    }
}
