package com.spindola.atividade_02_pp.model;

import java.util.ArrayList;
import java.util.List;

import com.spindola.atividade_02_pp.components.antenas.AntenaHuawei;
import com.spindola.atividade_02_pp.components.antenas.AntenaIntel;
import com.spindola.atividade_02_pp.components.antenas.AntenaTPLink;
import com.spindola.atividade_02_pp.components.chipset.ChipsetQualcomm;
import com.spindola.atividade_02_pp.components.chipset.ChipsetRealtek;
import com.spindola.atividade_02_pp.components.fonte.FonteCorsair;
import com.spindola.atividade_02_pp.components.fonte.FonteSeasonic;
import com.spindola.atividade_02_pp.components.placa.PlacaAmd;
import com.spindola.atividade_02_pp.components.placa.PlacaBroadcom;
import com.spindola.atividade_02_pp.components.placa.PlacaIntel;
import com.spindola.atividade_02_pp.components.placa.PlacaQualcomm;
import com.spindola.atividade_02_pp.interfaces.IAntena;
import com.spindola.atividade_02_pp.interfaces.IChipset;
import com.spindola.atividade_02_pp.interfaces.IFonteAlimentacao;
import com.spindola.atividade_02_pp.interfaces.IPlacaDeRede;

public class Simulador {

    // Instância única (Singleton)
    private static Simulador instancia;

    // Listas de componentes
    private List<IAntena> antenas;
    private List<IChipset> chipsets;
    private List<IFonteAlimentacao> fontes;
    private List<IPlacaDeRede> placasDeRede;

    // Lista de roteador
    private List<Roteador> roteadores;
    private Long proximoId = 1L;

    // Construtor privado
    private Simulador() {
        antenas = new ArrayList<>();
        chipsets = new ArrayList<>();
        fontes = new ArrayList<>();
        placasDeRede = new ArrayList<>();
        roteadores = new ArrayList<>();

        // Adicionando antenas
        antenas.add(new AntenaHuawei());
        antenas.add(new AntenaIntel());
        antenas.add(new AntenaTPLink());

        // Adicionando chipsets
        chipsets.add(new ChipsetQualcomm());
        chipsets.add(new ChipsetRealtek());

        // Adicionando fontes de alimentação
        fontes.add(new FonteCorsair());
        fontes.add(new FonteSeasonic());

        // Adicionando placas de rede
        placasDeRede.add(new PlacaAmd());
        placasDeRede.add(new PlacaBroadcom());
        placasDeRede.add(new PlacaIntel());
        placasDeRede.add(new PlacaQualcomm());
    }

    // Método de acesso ao Singleton
    public static Simulador getInstance() {
        if (instancia == null) {
            instancia = new Simulador();
        }
        return instancia;
    }

    public void adicionarRoteador(String modelo, String fabricante, IAntena antena, IChipset chipset, IFonteAlimentacao fonte, IPlacaDeRede placa) {
        Roteador roteador = new Roteador(proximoId++, modelo, fabricante, antena, chipset, fonte, placa);
        roteadores.add(roteador);
    }

    public List<IAntena> getAntenas() {
        return antenas;
    }

    public List<IChipset> getChipsets() {
        return chipsets;
    }

    public List<IFonteAlimentacao> getFontes() {
        return fontes;
    }

    public List<IPlacaDeRede> getPlacasDeRedes() {
        return placasDeRede;
    }

    public List<Roteador> getRoteadores() {
        return roteadores;
    }
}
