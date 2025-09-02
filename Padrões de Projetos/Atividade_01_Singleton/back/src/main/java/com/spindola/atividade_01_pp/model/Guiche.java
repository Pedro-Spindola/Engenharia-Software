package com.spindola.atividade_01_pp.model;

public class Guiche {
    private int id;
    private String nome;
    private SalaAtendimento sala;
    private boolean ocupado;
    private String pessoaAtendida;

    public Guiche(int id, String nome, SalaAtendimento sala){
        this.id = id;
        this.nome = nome;
        this.sala = sala;
        ocupado = false;
    }

    // Get e Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala.getNome();
    }

    public void setSala(SalaAtendimento sala) {
        this.sala = sala;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public String getPessoaAtendida() {
        return pessoaAtendida;
    }

    public void setPessoaAtendida(String pessoaAtendida) {
        this.pessoaAtendida = pessoaAtendida;
    }

}
