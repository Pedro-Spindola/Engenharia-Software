package com.spindola;

import com.spindola.controller.TarefaController;
import com.spindola.model.Responsavel;
import com.spindola.repository.IResponsavel;
import com.spindola.repository.ITarefaRepository;
import com.spindola.repository.ResponsavelMemoria;
import com.spindola.repository.TarefaRepositoryMemoria;
import com.spindola.services.TarefaServices;

public class Main {
    public static void main(String[] args) {
        ITarefaRepository repositoryTarefa = new TarefaRepositoryMemoria();
        IResponsavel  repositoryResponsavel = new ResponsavelMemoria();
        TarefaServices services = new TarefaServices(repositoryTarefa, repositoryResponsavel);
        TarefaController controller = new TarefaController(services);

        repositoryResponsavel.salvar(new Responsavel(1, "Pedro"));
        repositoryResponsavel.salvar(new Responsavel(2, "Henrique"));
        repositoryResponsavel.salvar(new Responsavel(3, "Spindola"));
        
        controller.executar();
    }
}