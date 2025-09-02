package com.spindola.atividade_03.model;

public class Piloto {
    private int matricula;
    private String nome;
    private String nacionalidade;
    private int idade;
    private String equipe;
    private String motor;
    private int pontos;

    public Piloto(int matricula, String nome, String nacionalidade, int idade, String equipe, String motor, int pontos) {
        this.matricula = matricula;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.equipe = equipe;
        this.motor = motor;
        this.pontos = pontos;
    }

    public int getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getNacionalidade() { return nacionalidade; }
    public int getIdade() { return idade; }
    public String getEquipe() { return equipe; }
    public String getMotor() { return motor; }
    public int getPontos() { return pontos; }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Nacionalidade: " + nacionalidade + ", Idade: " + idade + 
               ", Equipe: " + equipe + ", Motor: " + motor + ", Pontos: " + pontos;
    }

}
