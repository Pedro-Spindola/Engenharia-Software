package com.spindola.atividade_06.mapper;

import org.springframework.stereotype.Component;

import com.spindola.atividade_06.dto.DepartamentoRequestDTO;
import com.spindola.atividade_06.dto.DepartamentoResponseDTO;
import com.spindola.atividade_06.model.Departamento;

@Component
public class DepartamentoMapper {
    public DepartamentoResponseDTO toResponse(Departamento departamento){
        return new DepartamentoResponseDTO(
            departamento.getId(),
            departamento.getNome(),
            departamento.getSigla(),
            departamento.getAtivo()
        );
    }

    public Departamento toEntity(DepartamentoRequestDTO dto){
        Departamento departamento = new Departamento();
        departamento.setId(dto.id());
        departamento.setNome(dto.nome());
        departamento.setSigla(dto.sigla());
        departamento.setAtivo(dto.ativo());
        return departamento;
    }
}
