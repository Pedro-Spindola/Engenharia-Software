package com.spindola.atividade_02_pp.dto;

import com.spindola.atividade_02_pp.enums.TipoConector;

public class AdapterConectorDTO {
    private TipoConector entrada;
    private TipoConector saida;

    public AdapterConectorDTO() {}

    public AdapterConectorDTO(TipoConector entrada, TipoConector saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public TipoConector getEntrada() {
        return entrada;
    }

    public void setEntrada(TipoConector entrada) {
        this.entrada = entrada;
    }

    public TipoConector getSaida() {
        return saida;
    }

    public void setSaida(TipoConector saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Adapter usado de " + entrada + " para " + saida;
    }
}
