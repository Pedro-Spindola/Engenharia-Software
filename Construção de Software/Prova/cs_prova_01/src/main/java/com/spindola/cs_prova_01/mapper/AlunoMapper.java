package com.spindola.cs_prova_01.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spindola.cs_prova_01.dto.AlunoRequestAlterarDTO;
import com.spindola.cs_prova_01.dto.AlunoRequestRegistroDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseListDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.model.Aluno;
import com.spindola.cs_prova_01.model.AlunoTreinoVinculo;
import com.spindola.cs_prova_01.model.Plano;
import com.spindola.cs_prova_01.model.enums.StatusAluno;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestRegistroDTO dto){
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setData_nascimento(dto.data_nascimento());
        aluno.setStatus(StatusAluno.INATIVO);
        aluno.setPlano(null);
        aluno.setTreinos(new ArrayList<AlunoTreinoVinculo>());
        return aluno;
    }

    public Aluno toEntity(AlunoRequestAlterarDTO dto, Plano plano){
        Aluno aluno = new Aluno();
        aluno.setId(dto.id());
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setData_nascimento(dto.data_nascimento());
        aluno.setStatus(dto.statusAluno());
        aluno.setPlano(plano);
        aluno.setTreinos(new ArrayList<AlunoTreinoVinculo>());
        return aluno;
    }

    public AlunoResponseDTO toResponseDTO(Aluno aluno, PlanoResponseDTO planoDTO, List<TreinoResponseDTO> treinosDTO){
        AlunoResponseDTO alunoResponseDTO = new AlunoResponseDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getCpf(),
            aluno.getData_nascimento(),
            aluno.getData_ingressao(),
            aluno.getStatus(),
            planoDTO,
            treinosDTO);
            
        return alunoResponseDTO;
    }

    public AlunoResponseListDTO toResponseListDTO(Aluno aluno){
        AlunoResponseListDTO alunoResponseListDTO = new AlunoResponseListDTO(
            aluno.getId(),
            aluno.getNome()
            );
        return alunoResponseListDTO;
    }
}
