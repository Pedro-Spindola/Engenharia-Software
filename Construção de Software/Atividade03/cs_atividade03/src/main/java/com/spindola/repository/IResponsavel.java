package com.spindola.repository;

import java.util.List;
import java.util.Optional;

import com.spindola.model.Responsavel;

public interface IResponsavel {
    Responsavel salvar(Responsavel responsavel);
    List<Responsavel> listarTodos();
    Optional<Responsavel> buscarPeloId(Integer id);
}
