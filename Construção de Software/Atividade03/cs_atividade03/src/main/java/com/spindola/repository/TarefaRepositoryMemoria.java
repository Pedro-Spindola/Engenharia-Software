package com.spindola.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spindola.model.Tarefa;

public class TarefaRepositoryMemoria implements ITarefaRepository {
    private final Map<Integer, Tarefa> tarefas = new HashMap<>();

    @Override
    public Tarefa salvar(Tarefa tarefa) {
        tarefas.put(tarefa.getId(), tarefa);
        return tarefa;
    }
    
    @Override
    public List<Tarefa> listarTodos() {
        return new ArrayList<>(tarefas.values());
    }

    @Override
    public List<Tarefa> buscarPorTitulo(String titulo) {
        return tarefas.values().stream()
        .filter(t -> t.getTitulo().equals(titulo)).toList();
    }

    @Override
    public Optional<Tarefa> buscarPorId(Integer id) {
        return Optional.ofNullable(tarefas.get(id));
    }

    @Override
    public boolean atualizarTarefa(Tarefa tarefa) {
        tarefas.put(tarefa.getId(), tarefa);
        return true;
    }
}
