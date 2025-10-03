package com.spindola.atividade_06.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.spindola.atividade_06.observer.IEventoSubject;
import com.spindola.atividade_06.observer.IUsuarioObserver;

public class Corrida implements IEventoSubject {
    private String nome;
    private LocalDate data;
    private List<IUsuarioObserver> usuarios;

    public Corrida(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void notificarUsuarios(String mensagem) {
        for (IUsuarioObserver u : usuarios) u.atualizar(mensagem);
    }

    @Override
    public void registrarUsuario(IUsuarioObserver usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void removerUsuario(IUsuarioObserver usuario) {
        usuarios.remove(usuario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<IUsuarioObserver> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<IUsuarioObserver> usuarios) {
        this.usuarios = usuarios;
    }

    
}
