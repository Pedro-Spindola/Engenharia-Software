package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Latte implements ICafe {
    @Override
    public String getDescricao() {
        return "Latte";
    }

    @Override
    public double getCusto() {
        return 7.50;
    }
}
