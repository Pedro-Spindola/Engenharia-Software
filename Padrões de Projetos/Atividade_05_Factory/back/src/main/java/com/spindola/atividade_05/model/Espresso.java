package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Espresso implements ICafe {

    @Override
    public String getDescricao() {
        return "Expresso";
    }

    @Override
    public double getCusto() {
        return 5.00;
    }
}
