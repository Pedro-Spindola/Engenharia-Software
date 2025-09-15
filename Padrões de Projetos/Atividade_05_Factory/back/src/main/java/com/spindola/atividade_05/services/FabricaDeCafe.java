package com.spindola.atividade_05.services;

import com.spindola.atividade_05.model.Americano;
import com.spindola.atividade_05.model.Cappuccino;
import com.spindola.atividade_05.model.Espresso;
import com.spindola.atividade_05.model.Frappuccino;
import com.spindola.atividade_05.model.Latte;
import com.spindola.atividade_05.model.enums.TipoCafe;
import com.spindola.atividade_05.model.interfaces.ICafe;

public class FabricaDeCafe {
    private static FabricaDeCafe instancia;

    private FabricaDeCafe(){}

    public static FabricaDeCafe getInstance(){
        if(instancia == null) {
            instancia = new FabricaDeCafe();
        }
        return instancia;
    }

    public ICafe criarCafe(TipoCafe tipo){
        switch (tipo) {
            case AMERICANO:
                return new Americano();
            case CAPPUCCINO:
                return new Cappuccino();
            case ESPRESSO:
                return new Espresso();
            case FRAPPUCCINO:
                return new Frappuccino();
            case LATTE:
                return new Latte();
            default:
                throw new IllegalArgumentException("Tipo de café inválido: " + tipo);
        }
    }
}   
