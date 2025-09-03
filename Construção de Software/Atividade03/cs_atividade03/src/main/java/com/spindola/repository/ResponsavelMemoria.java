package com.spindola.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spindola.model.Responsavel;

public class ResponsavelMemoria implements IResponsavel {
    private final Map<Integer, Responsavel> responsaveis = new HashMap<>();

    @Override
    public Responsavel salvar(Responsavel responsavel) {
        responsaveis.put(responsavel.getId(), responsavel);
        return responsavel;
    }
    
    @Override
    public Optional<Responsavel> buscarPeloId(Integer id) {
        return Optional.ofNullable(responsaveis.get(id));
    }

    @Override
    public List<Responsavel> listarTodos() {
        return new ArrayList<>(responsaveis.values());
    }
    
}
