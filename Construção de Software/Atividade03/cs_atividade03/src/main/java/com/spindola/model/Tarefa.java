package com.spindola.model;

import java.time.LocalDateTime;

import com.spindola.enums.PrioridadeTarefa;
import com.spindola.enums.StatusTarefa;

public class Tarefa {
    private Integer id;
    private String titulo;
    private String descricao;
    private Responsavel responsavel;
    private StatusTarefa status;
    private PrioridadeTarefa prioridade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private static Integer contadorId = 1;

    public Tarefa(String titulo, String descricao, Responsavel responsavel, StatusTarefa status, PrioridadeTarefa prioridade) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.status = status;
        this.prioridade = prioridade;
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = null;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public PrioridadeTarefa getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.trim().length() < 3){
            throw new IllegalArgumentException("Titulo deve ter pelo menos 3 caracteres.");
        }
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResponsavel(Responsavel responsavel) {
        if(responsavel == null){
            throw new IllegalArgumentException("Responsavel não pode ser nulo.");
        }
        this.responsavel = responsavel;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public void setPrioridade(PrioridadeTarefa prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString() {
        return "Tarefa [getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getDescricao()=" + getDescricao()
                + ", getResponsavel()=" + getResponsavel() + ", getStatus()=" + getStatus() + ", getDataCriacao()="
                + getDataCriacao() + ", getDataConclusao()=" + getDataConclusao() + "]";
    }
    
}
