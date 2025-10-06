package com.spindola.cs_prova_01.model;

import java.util.List;

import com.spindola.cs_prova_01.model.enums.NivelTreino;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TREINO")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 1000)
    private String descricao;
    @Column(nullable = false)
    private NivelTreino nivelTreino;
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AlunoTreinoVinculo> alunos;

    public Treino() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public NivelTreino getNivelTreino() {
        return nivelTreino;
    }

    public void setNivelTreino(NivelTreino nivelTreino) {
        this.nivelTreino = nivelTreino;
    }
    
}
