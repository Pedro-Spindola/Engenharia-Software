package com.spindola.atividade_02_pp.model;

import com.spindola.atividade_02_pp.interfaces.IAntena;
import com.spindola.atividade_02_pp.interfaces.IChipset;
import com.spindola.atividade_02_pp.interfaces.IFonteAlimentacao;
import com.spindola.atividade_02_pp.interfaces.IPlacaDeRede;

public class Roteador {
    private Long id;
    private String modeloRoteador;
    private String fabricante;
    private IAntena antena;
    private IChipset chipset;
    private IFonteAlimentacao fonteAlimentacao;
    private IPlacaDeRede placaDeRede;

    private AdapterConector adapterAntena = null;
    private AdapterConector adapterFonte = null;
    private AdapterConector adapterChipset = null;

    public Roteador(Long id, String modeloRoteador, String fabricante, IAntena antena, IChipset chipset, IFonteAlimentacao fonteAlimentacao, IPlacaDeRede placaDeRede){
        this.id = id;
        this.modeloRoteador = modeloRoteador;
        this.fabricante = fabricante;
        this.antena = antena;
        this.chipset = chipset;
        this.fonteAlimentacao = fonteAlimentacao;
        this.placaDeRede = placaDeRede;
    }

    public void ligarRoteador(){
        System.out.println("Ligando Roteador: " + modeloRoteador + " - " + fabricante);
        System.out.println();
        // Verificar conectores e criar adapters se necessário
        if (placaDeRede.getTipoConectorAntena() != antena.getTipoConector()) {
            adapterAntena = new AdapterConector(antena.getTipoConector(), placaDeRede.getTipoConectorAntena());
        }

        if (placaDeRede.getTipoConectorChipset() != chipset.getTipoConector()) {
            adapterChipset = new AdapterConector(chipset.getTipoConector(), placaDeRede.getTipoConectorChipset());
        }

        if (placaDeRede.getTipoConectorFonteAlimentacao() != fonteAlimentacao.getTipoConector()) {
            adapterFonte = new AdapterConector(fonteAlimentacao.getTipoConector(), placaDeRede.getTipoConectorFonteAlimentacao());
        }

        System.out.println("[🛠 Diagnóstico dos Componentes]");
        System.out.println(antena.transmitirSinal());
        System.out.println(antena.receberSinal());
        System.out.println();

        System.out.println(chipset.processarDados());
        System.out.println();

        System.out.println(fonteAlimentacao.fornecerEnergia());
        System.out.println();

        System.out.println(placaDeRede.diagnostico());
        System.out.println(placaDeRede.enviarPacote());
        System.out.println(placaDeRede.receberPacote());
        System.out.println();

        if (adapterAntena != null) System.out.println("⚠️ Adapter usado na Antena: " + adapterAntena);
        if (adapterChipset != null) System.out.println("⚠️ Adapter usado no Chipset: " + adapterChipset);
        if (adapterFonte != null) System.out.println("⚠️ Adapter usado na Fonte de Alimentação: " + adapterFonte);

        System.out.println("\n✅ Roteador ligado com sucesso!");
    };

    public void listarComponentes() {
        System.out.println("Listando componentes do roteador " + modeloRoteador);
        System.out.println("Fabricante: " + fabricante);
        System.out.println();

        System.out.println("Antena:\n" + antena);
        System.out.println();

        System.out.println("Chipset:\n" + chipset);
        System.out.println();

        System.out.println("Fonte de Alimentação:\n" + fonteAlimentacao);
        System.out.println();

        System.out.println("Placa de Rede:\n" + placaDeRede);
        System.out.println();

        if (adapterAntena != null) System.out.println("⚠️ Adapter Antena: " + adapterAntena);
        if (adapterChipset != null) System.out.println("⚠️ Adapter Chipset: " + adapterChipset);
        if (adapterFonte != null) System.out.println("⚠️ Adapter Fonte: " + adapterFonte);

        System.out.println();
    }

    public Long getId() {
        return id;
    }

    public String getModeloRoteador() {
        return modeloRoteador;
    }

    public String getFabricante() {
        return fabricante;
    }

    public IAntena getAntena() {
        return antena;
    }

    public IChipset getChipset() {
        return chipset;
    }

    public IFonteAlimentacao getFonteAlimentacao() {
        return fonteAlimentacao;
    }

    public IPlacaDeRede getPlacaDeRede() {
        return placaDeRede;
    }

    public AdapterConector getAdapterAntena() {
        return adapterAntena;
    }

    public AdapterConector getAdapterFonte() {
        return adapterFonte;
    }

    public AdapterConector getAdapterChipset() {
        return adapterChipset;
    }
}
