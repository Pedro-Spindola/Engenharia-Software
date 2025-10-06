package com.spindola.cs_prova_01.mapper;

import org.springframework.stereotype.Component;

import com.spindola.cs_prova_01.dto.PlanoRequestDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.model.Plano;

@Component
public class PlanoMapper {
    public Plano toEntity(PlanoRequestDTO dto){
        Plano plano = new Plano();
        plano.setId(dto.id());
        plano.setNome(dto.nome());
        plano.setDescricao(dto.descricao());
        plano.setValor_mensal(dto.valor_mensal());
        return plano;
    }

    public PlanoResponseDTO toResponseDTO(Plano plano){
        PlanoResponseDTO planoResponseDTO = new PlanoResponseDTO(
            plano.getId(),
            plano.getNome(),
            plano.getDescricao(),
            plano.getValor_mensal());
        return planoResponseDTO;
    }
}
