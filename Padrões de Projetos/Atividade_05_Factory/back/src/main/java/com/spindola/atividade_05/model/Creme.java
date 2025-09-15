package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class Creme extends Adicionais{
    public Creme(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Creme";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 1.50;
    }
}
