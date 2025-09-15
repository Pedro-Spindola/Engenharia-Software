package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Leite extends Adicionais {

    public Leite(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Leite";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 2.25;
    }
}
