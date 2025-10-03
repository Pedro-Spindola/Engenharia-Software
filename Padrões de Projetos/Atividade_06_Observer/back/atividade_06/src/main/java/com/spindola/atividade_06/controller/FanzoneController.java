package com.spindola.atividade_06.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_06.model.Corrida;
import com.spindola.atividade_06.model.Usuario;
import com.spindola.atividade_06.service.FanzoneService;

@RestController
@RequestMapping("/fanzone")
public class FanzoneController {

    @Autowired
    FanzoneService service;

    @PostMapping("/evento")
    public String adicionarEvento(@RequestBody Corrida corrida){
        if (corrida.getUsuarios() == null) {
            corrida.setUsuarios(new ArrayList<>());
        }
        service.adicionarEvento(corrida);
        return "Evento adicionado!";
    }

    // Registrar Usuário
    @PostMapping("/usuario")
    public String registrarUsuario(@RequestBody Usuario usuario){
        boolean registrado = service.registrarUsuario(usuario);
        return registrado ? "Usuário registrado!" : "Evento não encontrado!";
    }

    // Pular dia
    @PostMapping("/pularDia")
    public String pularDia() {
        return service.passarDia();
    }

    @PostMapping("/inscrever")
    public String inscreverUsuario(@RequestParam String nomeUsuario, @RequestParam String nomeEvento) {
        boolean inscrito = service.inscreverUsuarioNoEvento(nomeUsuario, nomeEvento);
        return inscrito ? "Usuário inscrito no evento!" : "Usuário ou evento não encontrado!";
    }

}

