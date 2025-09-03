package com.spindola.services;

import java.util.List;

import com.spindola.enums.PrioridadeTarefa;
import com.spindola.enums.StatusTarefa;
import com.spindola.model.Responsavel;
import com.spindola.model.Tarefa;
import com.spindola.repository.IResponsavel;
import com.spindola.repository.ITarefaRepository;

public class TarefaServices {
    private final ITarefaRepository repositoryTarefa;
    private final IResponsavel repositoryResponsavel;

    public TarefaServices(ITarefaRepository repositoryTarefa, IResponsavel repositoryResponsavel){
        this.repositoryTarefa = repositoryTarefa;
        this.repositoryResponsavel = repositoryResponsavel;
    }

    public Tarefa cadastrarTarefa(String titulo, String descricao, Integer resp, Integer stt, Integer priordd){
        if(!repositoryResponsavel.buscarPeloId(priordd).isPresent()){
            throw new IllegalArgumentException("Responsavel escolhido inválido");
        }
        Responsavel responsavel = repositoryResponsavel.buscarPeloId(priordd).get();
        StatusTarefa status;
        PrioridadeTarefa prioridadeTarefa;
        switch (stt) {
            case 1 -> status = StatusTarefa.PENDENTE;
            case 2 -> status = StatusTarefa.EM_ANDAMENTO;
            default -> throw new IllegalArgumentException("Opção de Status inválido");
        }

        switch (priordd) {
            case 1 -> prioridadeTarefa = PrioridadeTarefa.BAIXA;
            case 2 -> prioridadeTarefa = PrioridadeTarefa.MEDIA;
            case 3 -> prioridadeTarefa = PrioridadeTarefa.ALTA;
            default -> throw new IllegalArgumentException("Opção de Prioridade inválido");
        }

        if(repositoryTarefa.buscarPorTitulo(titulo).size() > 1){
            for(Tarefa t : repositoryTarefa.buscarPorTitulo(titulo)){
                if(t.getResponsavel() == responsavel){
                    throw new IllegalArgumentException("Já existe uma tarefa com o nome " + titulo + " designado para o responsavel " + responsavel.getNome());
                }
            }
        }

        Tarefa novTarefa = new Tarefa(titulo, descricao, responsavel, status, prioridadeTarefa);
        return repositoryTarefa.salvar(novTarefa);
    }

    public List<Tarefa> listarTarefas(){
        return repositoryTarefa.listarTodos();
    }

    public List<Responsavel> listarResponsavel(){
        return repositoryResponsavel.listarTodos();
    }
}
