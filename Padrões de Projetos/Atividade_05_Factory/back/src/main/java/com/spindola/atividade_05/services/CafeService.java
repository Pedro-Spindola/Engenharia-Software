package com.spindola.atividade_05.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spindola.atividade_05.model.enums.TipoAdicionais;
import com.spindola.atividade_05.model.enums.TipoCafe;
import com.spindola.atividade_05.model.interfaces.ICafe;

@Service
public class CafeService {
    private final FabricaDeCafe fabricaDeCafe = FabricaDeCafe.getInstance();
    private final FabricaDeAdicionais fabricaDeAdicionais = FabricaDeAdicionais.getInstance();

    public ICafe processarPedido(TipoCafe tipo, List<TipoAdicionais> adicionais){
        ICafe cafeFinal = fabricaDeCafe.criarCafe(tipo);
        if (adicionais != null && !adicionais.isEmpty()){
            for (TipoAdicionais tipoAdc : adicionais){
                cafeFinal = fabricaDeAdicionais.criarAdicional(tipoAdc, cafeFinal);
            }
        }
        return cafeFinal;
    }
}
