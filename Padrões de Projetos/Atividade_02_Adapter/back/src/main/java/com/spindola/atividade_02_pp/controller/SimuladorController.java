package com.spindola.atividade_02_pp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spindola.atividade_02_pp.dto.RoteadorDTO;
import com.spindola.atividade_02_pp.dto.RoteadorResponseDTO;
import com.spindola.atividade_02_pp.interfaces.IAntena;
import com.spindola.atividade_02_pp.interfaces.IChipset;
import com.spindola.atividade_02_pp.interfaces.IFonteAlimentacao;
import com.spindola.atividade_02_pp.interfaces.IPlacaDeRede;
import com.spindola.atividade_02_pp.model.Roteador;
import com.spindola.atividade_02_pp.service.SimuladorService;

@RestController
@RequestMapping("/simulador")
public class SimuladorController {
    
    @Autowired
    private SimuladorService simuladorService;

    @GetMapping("/antenas")
    public List<IAntena> getListAntenas() {
        return simuladorService.getAntenas();
    }

    @GetMapping("/chipsets")
    public List<IChipset> getListChipset() {
        return simuladorService.getChipsets();
    }

    @GetMapping("/fontes")
    public List<IFonteAlimentacao> getListFonte() {
        return simuladorService.getFontes();
    }

    @GetMapping("/placas")
    public List<IPlacaDeRede> getListPlaca() {
        return simuladorService.getPlacaDeRedes();
    }

    @GetMapping("/roteadores")
    public List<Roteador> getRoteadores() {
        return simuladorService.getRoteadores();
    }

    @PostMapping("/roteadores")
    public RoteadorResponseDTO criarRoteador(@RequestBody RoteadorDTO dto) {
        Roteador r = simuladorService.adicionarRoteador(dto);
        return new RoteadorResponseDTO(r);
    }
}