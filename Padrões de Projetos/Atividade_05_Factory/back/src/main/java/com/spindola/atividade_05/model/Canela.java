package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Canela extends Adicionais {
    public Canela(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Canela";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 0.75;
    }
}
