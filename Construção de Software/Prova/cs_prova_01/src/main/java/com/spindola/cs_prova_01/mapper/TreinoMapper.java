package com.spindola.cs_prova_01.mapper;

import org.springframework.stereotype.Component;

import com.spindola.cs_prova_01.dto.TreinoRequestDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.model.Treino;

@Component
public class TreinoMapper {
    public Treino toEntity(TreinoRequestDTO dto){
        Treino treino = new Treino();
        treino.setId(dto.id());
        treino.setNome(dto.nome());
        treino.setDescricao(dto.descricao());
        treino.setNivelTreino(dto.nivelTreino());
        return treino;
    }

    public TreinoResponseDTO toResponseDTO(Treino treino){
        TreinoResponseDTO treinoResponseDTO = new TreinoResponseDTO(
            treino.getId(),
            treino.getNome(),
            treino.getDescricao(),
            treino.getNivelTreino());
            return treinoResponseDTO;
    }
}
