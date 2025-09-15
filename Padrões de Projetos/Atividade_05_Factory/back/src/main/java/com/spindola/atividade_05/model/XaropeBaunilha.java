package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class XaropeBaunilha extends Adicionais {
    public XaropeBaunilha(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Xarope Baunilha";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 1.25;
    }
}
