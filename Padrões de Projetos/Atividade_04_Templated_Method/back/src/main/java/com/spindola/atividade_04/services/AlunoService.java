package com.spindola.atividade_04.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import com.spindola.atividade_04.model.Aluno;
import com.spindola.atividade_04.repository.AlunoRepositoryTemplateMethod;
import com.spindola.atividade_04.repository.OrdenaCursoEnfase;
import com.spindola.atividade_04.repository.OrdenaCursoNome;
import com.spindola.atividade_04.repository.OrdenaEnfaseCurso;
import com.spindola.atividade_04.repository.OrdenaEnfaseNome;
import com.spindola.atividade_04.repository.OrdenaNome;
import com.spindola.atividade_04.repository.OrdenaSituacaoNome;
import com.spindola.atividade_04.repository.OrdenaSobrenome;

@Service
public class AlunoService {

    public List<Aluno> ordenarCursoEnfase() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaCursoEnfase();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarCursoNome() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaCursoNome();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarEnfaseCurso() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaEnfaseCurso();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarEnfaseNome() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaEnfaseNome();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarNome() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaNome();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarSituacaoNome() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaSituacaoNome();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }

    public List<Aluno> ordenarSobrenome() throws IOException{
        try {
            AlunoRepositoryTemplateMethod ordenacao = new OrdenaSobrenome();
            return ordenacao.getListOrdenada();
        } catch (IOException erro) {
            throw new RuntimeException("Não foi possível carregar os dados", erro);
        }
    }
}
