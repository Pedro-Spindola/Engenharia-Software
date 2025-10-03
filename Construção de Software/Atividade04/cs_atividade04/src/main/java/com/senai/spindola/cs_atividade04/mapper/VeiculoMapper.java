package com.senai.spindola.cs_atividade04.mapper;

import com.senai.spindola.cs_atividade04.dto.VeiculoRequestDTO;
import com.senai.spindola.cs_atividade04.dto.VeiculoResponseDTO;
import com.senai.spindola.cs_atividade04.model.Veiculo;

public class VeiculoMapper {

    public Veiculo toEntity(VeiculoRequestDTO dto){
        Veiculo veiculo = new Veiculo(dto.placa(), dto.modelo(), dto.cor());
        return veiculo;
    }

    public VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
        return new VeiculoResponseDTO(veiculo.getId(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor(), veiculo.getDataEntrada(), veiculo.getDataSaida(), veiculo.getValorPago());
    }
    
}
