package com.spindola.atividade_02_pp.components.placa;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IPlacaDeRede;

public class PlacaIntel implements IPlacaDeRede {
    private Integer id;
    private String modelo;
    private double taxaTransferencia;
    private TipoConector tipoConectorAntena;
    private TipoConector tipoConectorChipset;
    private TipoConector tipoConectorFonte;

    public PlacaIntel(){
        id = 003;
        modelo = "Intel P755";
        taxaTransferencia = 4000;
        tipoConectorAntena = TipoConector.VX12;
        tipoConectorChipset = TipoConector.P3;
        tipoConectorFonte = TipoConector.RK40;
    }

    @Override
    public Integer getId(){
        return id;
    };

    public String getModelo(){
        return modelo;
    }

    public double getTaxaTransferencia(){
        return taxaTransferencia;
    }

    @Override
    public String enviarPacote() {
        return modelo + " enviando pacote com taxa de " + taxaTransferencia + " Mbps";
    }

    @Override
    public String receberPacote() {
        return modelo + " recebendo pacote";
    }

    @Override
    public TipoConector getTipoConectorAntena() {
        return tipoConectorAntena;
    }

    @Override
    public TipoConector getTipoConectorChipset() {
        return tipoConectorChipset;
    }

    @Override
    public TipoConector getTipoConectorFonteAlimentacao() {
        return tipoConectorFonte;
    }

    @Override
    public String diagnostico() {
        return "Placa de rede " + modelo + " OK";
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo +
            "\n - Taxa de Transferência: " + taxaTransferencia + " Mbps" +
            "\n - Conector Antena: " + tipoConectorAntena +
            "\n - Conector Chipset: " + tipoConectorChipset +
            "\n - Conector Fonte: " + tipoConectorFonte;
    }
}
