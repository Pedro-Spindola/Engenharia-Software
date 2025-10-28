package com.spindola.atividade_06.mapper;

import org.springframework.stereotype.Component;

import com.spindola.atividade_06.dto.DepartamentoResponseDTO;
import com.spindola.atividade_06.dto.FuncionarioRequestDTO;
import com.spindola.atividade_06.dto.FuncionarioResponseDTO;
import com.spindola.atividade_06.model.Departamento;
import com.spindola.atividade_06.model.Funcionario;

@Component
public class FuncionarioMapper {
    
    public FuncionarioResponseDTO toResponse(Funcionario funcionario, DepartamentoResponseDTO derpatamentoResponseDTO){
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getEmail(),
            funcionario.getCargo(),
            funcionario.getSalario(),
            funcionario.getDataAdmissao(),
            funcionario.getAtivo(),
            derpatamentoResponseDTO
        );
    }

    public Funcionario toEntity(FuncionarioRequestDTO dto, Departamento derpatamento){
        Funcionario funcionario = new Funcionario();
            funcionario.setId(dto.id());
            funcionario.setNome(dto.nome());
            funcionario.setEmail(dto.email());
            funcionario.setCargo(dto.cargo());
            funcionario.setSalario(dto.salario());
            funcionario.setAtivo(dto.status());
        return funcionario;
    }
}
