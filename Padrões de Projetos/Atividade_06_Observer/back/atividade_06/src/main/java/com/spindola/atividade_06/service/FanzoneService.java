package com.spindola.atividade_06.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spindola.atividade_06.model.Corrida;
import com.spindola.atividade_06.model.Usuario;

@Service
public class FanzoneService {
    private LocalDate dataAtual = LocalDate.now();
    private List<Corrida> eventos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    public static String notificacaoDoDia = "";

    public boolean adicionarEvento(Corrida corrida){
        return eventos.add(corrida);
    }

    public boolean registrarUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }

    public String passarDia(){
        dataAtual = dataAtual.plusDays(1);
        verificarEventos();
        return notificacaoDoDia;
    }

    public void verificarEventos() {
        notificacaoDoDia = "Notificações" + dataAtual + ":\n ";
        for (Corrida corrida : eventos){
            if(corrida.getData().equals(dataAtual))corrida.notificarUsuarios(corrida.getNome());
        }
    }

    public boolean inscreverUsuarioNoEvento(String nomeUsuario, String nomeEvento) {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getNome().equals(nomeUsuario))
                .findFirst()
                .orElse(null);

        Corrida corrida = eventos.stream()
                .filter(e -> e.getNome().equals(nomeEvento))
                .findFirst()
                .orElse(null);

        if (usuario != null && corrida != null) {
            corrida.registrarUsuario(usuario);
            return true;
        }

        return false;
    }


}
