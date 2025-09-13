package com.spindola.atividade_04.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.spindola.atividade_04.model.Aluno;

public abstract class AlunoRepositoryTemplateMethod {
    private List<Aluno> alunos = new ArrayList<>();

    public abstract List<Aluno> ordenacao(List<Aluno> alunos);

    public List<Aluno> getListOrdenada() throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("com/spindola/atividade_04/resources/RelatorioDasEnfases.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String linha;
            br.readLine();
            
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                
                Aluno aluno = new Aluno(dados[0], dados[1], dados[2], dados[3]);
                alunos.add(aluno);
            }
            return ordenacao(alunos);
            
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados. Detalhes: " + erro.getMessage(), erro);
        }
    }
}
