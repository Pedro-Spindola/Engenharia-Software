package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public abstract class Adicionais implements ICafe {
    protected ICafe cafe;

    public Adicionais(ICafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao();
    }

    @Override
    public double getCusto() {
        return cafe.getCusto();
    }
}
