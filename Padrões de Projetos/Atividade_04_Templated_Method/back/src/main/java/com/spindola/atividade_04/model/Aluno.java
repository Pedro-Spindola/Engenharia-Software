package com.spindola.atividade_04.model;

public class Aluno {
    private String nome;
    private String curso;
    private String situacao;
    private String enfase;

    public Aluno(String nome, String curso, String situacao, String enfase) {
        this.nome = nome;
        this.curso = curso;
        this.situacao = situacao;
        this.enfase = enfase;
    }
    
    public String getNome() {
        return nome;
    }
    public String getCurso() {
        return curso;
    }
    public String getSituacao() {
        return situacao;
    }
    public String getEnfase() {
        return enfase;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public void setEnfase(String enfase) {
        this.enfase = enfase;
    }

    
}
