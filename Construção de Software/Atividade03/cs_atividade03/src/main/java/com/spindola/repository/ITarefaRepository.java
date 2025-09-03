package com.spindola.repository;

import java.util.List;
import java.util.Optional;

import com.spindola.model.Tarefa;

public interface ITarefaRepository {
    Tarefa salvar(Tarefa tarefa);
    List<Tarefa> listarTodos();
    List<Tarefa> buscarPorTitulo(String titulo);
    Optional<Tarefa> buscarPorId(Integer id);
    boolean atualizarTarefa(Tarefa tarefa);
}
