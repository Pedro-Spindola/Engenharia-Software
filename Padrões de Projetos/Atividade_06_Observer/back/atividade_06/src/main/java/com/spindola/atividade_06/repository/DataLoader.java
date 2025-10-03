package com.spindola.atividade_06.repository;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spindola.atividade_06.model.Corrida;
import com.spindola.atividade_06.model.Usuario;
import com.spindola.atividade_06.service.FanzoneService;

@Component
public class DataLoader implements CommandLineRunner {

    private final FanzoneService service;

    public DataLoader(FanzoneService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        // Criando Corridas
        Corrida corrida1 = new Corrida("GP Interlagos", LocalDate.now().plusDays(1));
        Corrida corrida2 = new Corrida("24 Horas de Le Mans", LocalDate.now().plusDays(3));
        Corrida corrida3 = new Corrida("24 Horas de Spa Francorchamps", LocalDate.now().plusDays(4));

        service.adicionarEvento(corrida1);
        service.adicionarEvento(corrida2);
        service.adicionarEvento(corrida3);

        // Criando Usuários
        Usuario usuario1 = new Usuario("Pedro", true);
        Usuario usuario2 = new Usuario("Beatriz", true);
        Usuario usuario3 = new Usuario("Joao", true);

        service.registrarUsuario(usuario1);
        service.registrarUsuario(usuario2);
        service.registrarUsuario(usuario3);

        // Inscrevendo usuários nos eventos
        service.inscreverUsuarioNoEvento("Pedro", "GP Interlagos");
        service.inscreverUsuarioNoEvento("Pedro", "24 Horas de Le Mans");
        service.inscreverUsuarioNoEvento("Pedro", "24 Horas de Spa Francorchamps");
        service.inscreverUsuarioNoEvento("Beatriz", "GP Interlagos");
        service.inscreverUsuarioNoEvento("Beatriz", "24 Horas de Spa Francorchamps");
        service.inscreverUsuarioNoEvento("Joao", "GP Interlagos");

        System.out.println("Eventos e usuários iniciais carregados!");
    }
}
