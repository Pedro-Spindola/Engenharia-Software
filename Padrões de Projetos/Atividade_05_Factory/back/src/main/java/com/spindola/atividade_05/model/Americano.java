package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Americano implements ICafe {
    @Override
    public String getDescricao() {
        return "Americano";
    }

    @Override
    public double getCusto() {
        return 3.00;
    }
}
