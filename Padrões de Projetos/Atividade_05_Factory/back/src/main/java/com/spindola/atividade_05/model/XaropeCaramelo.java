package com.spindola.atividade_05.model;

import com.spindola.atividade_05.model.interfaces.ICafe;

public class XaropeCaramelo extends Adicionais {
    public XaropeCaramelo(ICafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescricao() {
        return cafe.getDescricao() + ", Xarope Caramelo";
    }

    @Override
    public double getCusto() {
        return cafe.getCusto() + 1.25;
    }
}
