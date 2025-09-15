package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Acucar extends Adicionais {

    public Acucar(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Açúcar";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 0.50;
    }
}
