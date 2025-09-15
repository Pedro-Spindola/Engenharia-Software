package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Cappuccino implements ICafe {
    @Override
    public String getDescricao() {
        return "Cappuccino";
    }

    @Override
    public double getCusto() {
        return 11.00;
    }
}
