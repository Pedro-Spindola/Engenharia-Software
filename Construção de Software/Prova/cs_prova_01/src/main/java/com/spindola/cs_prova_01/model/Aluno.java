package com.spindola.cs_prova_01.model;

import java.time.LocalDate;
import java.util.List;

import com.spindola.cs_prova_01.model.enums.StatusAluno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false)
    private LocalDate data_nascimento;
    @Column(nullable = false)
    private LocalDate data_ingressao;
    private StatusAluno status;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AlunoTreinoVinculo> alunos;

    public Aluno() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public LocalDate getData_ingressao() {
        return data_ingressao;
    }

    public void setData_ingressao(LocalDate data_ingressao) {
        this.data_ingressao = data_ingressao;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<AlunoTreinoVinculo> getTreinos() {
        return alunos;
    }

    public void setTreinos(List<AlunoTreinoVinculo> alunos) {
        this.alunos = alunos;
    }

}
