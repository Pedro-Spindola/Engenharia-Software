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

    public Tarefa buscarPeloId(Integer id){
        return repositoryTarefa.buscarPorId(id).get();
    }

    public boolean removerTarefa(Integer id){
        if(repositoryTarefa.buscarPorId(id).isPresent()){
            repositoryTarefa.removerTarefa(id);
            return true;
        }
        return false;
    }

    public Tarefa atualizarTarefa(Integer id, String titulo, String descricao, Integer resp, Integer priordd){
        if(!repositoryTarefa.buscarPorId(id).isPresent()){
            throw new IllegalArgumentException("Tarefa não encontrada, ID inexistente.");
        } 
        if(!repositoryResponsavel.buscarPeloId(priordd).isPresent()){
            throw new IllegalArgumentException("Responsavel escolhido inválido");
        }
        Responsavel responsavel = repositoryResponsavel.buscarPeloId(priordd).get();
        PrioridadeTarefa prioridadeTarefa;

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

        Tarefa tarefaAtualizada = repositoryTarefa.buscarPorId(id).get();
        tarefaAtualizada.setTitulo(titulo);
        tarefaAtualizada.setDescricao(descricao);
        tarefaAtualizada.setResponsavel(responsavel);
        tarefaAtualizada.setPrioridade(prioridadeTarefa);
        if(repositoryTarefa.atualizarTarefa(tarefaAtualizada)) return tarefaAtualizada;
        return null;
    }

    public boolean atualizarStatus(Integer id, int intStatus){
        if(!repositoryTarefa.buscarPorId(id).isPresent()){
            throw new IllegalArgumentException("Tarefa não encontrada, ID inexistente.");
        }
        StatusTarefa status;
        switch (intStatus) {
            case 1 -> status = StatusTarefa.PENDENTE;
            case 2 -> status = StatusTarefa.EM_ANDAMENTO;
            case 3 -> status = StatusTarefa.CONCLUIDA;
            default -> throw new IllegalArgumentException("Opção de Status inválido");
        }
        Tarefa tarefaAtualizada = repositoryTarefa.buscarPorId(id).get();
        tarefaAtualizada.setStatus(status);
        if(repositoryTarefa.atualizarTarefa(tarefaAtualizada)) return true;
        return false;
    }

}
