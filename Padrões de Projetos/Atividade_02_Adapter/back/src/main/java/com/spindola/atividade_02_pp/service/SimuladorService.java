package com.spindola.atividade_02_pp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spindola.atividade_02_pp.dto.RoteadorDTO;
import com.spindola.atividade_02_pp.interfaces.IAntena;
import com.spindola.atividade_02_pp.interfaces.IChipset;
import com.spindola.atividade_02_pp.interfaces.IFonteAlimentacao;
import com.spindola.atividade_02_pp.interfaces.IPlacaDeRede;
import com.spindola.atividade_02_pp.model.Roteador;
import com.spindola.atividade_02_pp.model.Simulador;

@Service
public class SimuladorService {
    private Simulador simulador;

    public SimuladorService() {
        this.simulador = Simulador.getInstance();
    }

    public List<IAntena> getAntenas() {
        return simulador.getAntenas();
    }

    public List<IChipset> getChipsets() {
        return simulador.getChipsets();
    }

    public List<IFonteAlimentacao> getFontes() {
        return simulador.getFontes();
    }

    public List<IPlacaDeRede> getPlacaDeRedes() {
        return simulador.getPlacasDeRedes();
    }

    public List<Roteador> getRoteadores(){
        return simulador.getRoteadores();
    }

    public Roteador adicionarRoteador(RoteadorDTO dto) {
        System.out.println("Antenas disponíveis: " + simulador.getAntenas());
        System.out.println("IDs do DTO: " + dto.getAntenaId() + ", " + dto.getChipsetId() + ", " + dto.getFonteId() + ", " + dto.getPlacaId());

        IAntena antena = simulador.getAntenas().stream()
            .filter(a -> a.getId().equals(dto.getAntenaId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Antena não encontrada"));

        IChipset chipset = simulador.getChipsets().stream()
            .filter(c -> c.getId().equals(dto.getChipsetId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Chipset não encontrado"));

        IFonteAlimentacao fonte = simulador.getFontes().stream()
            .filter(f -> f.getId().equals(dto.getFonteId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Fonte não encontrada"));

        IPlacaDeRede placa = simulador.getPlacasDeRedes().stream()
            .filter(p -> p.getId().equals(dto.getPlacaId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Placa não encontrada"));

        simulador.adicionarRoteador(dto.getModeloRoteador(), dto.getFabricante(), antena, chipset, fonte, placa);

        return simulador.getRoteadores().get(simulador.getRoteadores().size() - 1);
    }
}
