package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Frappuccino implements ICafe {
    @Override
    public String getDescricao() {
        return "Frappuccino";
    }

    @Override
    public double getCusto() {
        return 12.25;
    }
}
