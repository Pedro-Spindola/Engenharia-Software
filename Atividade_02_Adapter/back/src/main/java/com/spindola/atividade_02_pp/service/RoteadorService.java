package com.spindola.atividade_02_pp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spindola.atividade_02_pp.dto.AdapterConectorDTO;
import com.spindola.atividade_02_pp.dto.RoteadorComponentesResponseDTO;
import com.spindola.atividade_02_pp.dto.RoteadorLigacaoResponseDTO;
import com.spindola.atividade_02_pp.model.Roteador;
import com.spindola.atividade_02_pp.model.Simulador;

@Service
public class RoteadorService {
    
    private Simulador simulador;

    public RoteadorService(){
        this.simulador = Simulador.getInstance();
    }

    private Roteador findRoteador(Long id) {
        return simulador.getRoteadores().stream()
            .filter(r -> r.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roteador não encontrado"));
    }

    public RoteadorComponentesResponseDTO listarComponentes(Long id) {
        Roteador r = findRoteador(id);

        AdapterConectorDTO adpAnt = r.getAdapterAntena() == null ? null
                : new AdapterConectorDTO(r.getAdapterAntena().getEntrada(), r.getAdapterAntena().getSaida());
        AdapterConectorDTO adpChip = r.getAdapterChipset() == null ? null
                : new AdapterConectorDTO(r.getAdapterChipset().getEntrada(), r.getAdapterChipset().getSaida());
        AdapterConectorDTO adpFonte = r.getAdapterFonte() == null ? null
                : new AdapterConectorDTO(r.getAdapterFonte().getEntrada(), r.getAdapterFonte().getSaida());

        return new RoteadorComponentesResponseDTO(
            r.getId(),
            r.getModeloRoteador(),
            r.getFabricante(),
            r.getAntena(),
            r.getChipset(),
            r.getFonteAlimentacao(),
            r.getPlacaDeRede(),
            adpAnt,
            adpChip,
            adpFonte
        );
    }

    public RoteadorLigacaoResponseDTO ligarRoteador(Long id) {
        Roteador r = findRoteador(id);

        // chama seu método existente que imprime no console e atualiza adapters
        r.ligarRoteador();

        // monta as mensagens para enviar ao front
        List<String> diag = new ArrayList<>();
        diag.add("[🛠 Diagnóstico dos Componentes]");
        diag.add(r.getAntena().transmitirSinal());
        diag.add(r.getAntena().receberSinal());
        diag.add(r.getChipset().processarDados());
        diag.add(r.getFonteAlimentacao().fornecerEnergia());
        diag.add(r.getPlacaDeRede().diagnostico());
        diag.add(r.getPlacaDeRede().enviarPacote());
        diag.add(r.getPlacaDeRede().receberPacote());

        AdapterConectorDTO adpAnt = r.getAdapterAntena() == null ? null
                : new AdapterConectorDTO(r.getAdapterAntena().getEntrada(), r.getAdapterAntena().getSaida());
        AdapterConectorDTO adpChip = r.getAdapterChipset() == null ? null
                : new AdapterConectorDTO(r.getAdapterChipset().getEntrada(), r.getAdapterChipset().getSaida());
        AdapterConectorDTO adpFonte = r.getAdapterFonte() == null ? null
                : new AdapterConectorDTO(r.getAdapterFonte().getEntrada(), r.getAdapterFonte().getSaida());

        return new RoteadorLigacaoResponseDTO(
            r.getId(),
            r.getModeloRoteador(),
            r.getFabricante(),
            diag,
            adpAnt,
            adpChip,
            adpFonte,
            "✅ Roteador ligado com sucesso!"
        );
    }
}
