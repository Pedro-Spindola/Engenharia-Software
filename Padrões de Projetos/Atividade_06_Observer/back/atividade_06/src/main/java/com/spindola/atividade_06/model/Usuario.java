package com.spindola.atividade_06.model;

import com.spindola.atividade_06.observer.IUsuarioObserver;
import com.spindola.atividade_06.service.FanzoneService;

public class Usuario implements IUsuarioObserver {
    private String nome;
    private boolean notificacoesAtivas;

    public Usuario(String nome, boolean notificacoesAtivas) {
        this.nome = nome;
        this.notificacoesAtivas = notificacoesAtivas;
    }

    @Override
    public void atualizar(String mensagem) {
        if(notificacoesAtivas) FanzoneService.notificacaoDoDia += ("\nOlá " + nome + " o grande dia do evento " + mensagem + " chegou!!!\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isNotificacoesAtivas() {
        return notificacoesAtivas;
    }

    public void setNotificacoesAtivas(boolean notificacoesAtivas) {
        this.notificacoesAtivas = notificacoesAtivas;
    }
}
