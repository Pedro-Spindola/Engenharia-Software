package com.spindola.atividade_06.observer;

public interface IEventoSubject {
    void registrarUsuario(IUsuarioObserver usuario);
    void removerUsuario(IUsuarioObserver usuario);
    void notificarUsuarios(String mensagem);
}
