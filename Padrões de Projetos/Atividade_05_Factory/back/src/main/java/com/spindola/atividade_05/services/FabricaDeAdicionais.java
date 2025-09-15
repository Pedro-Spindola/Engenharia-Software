package com.spindola.atividade_05.services;

import com.spindola.atividade_05.model.Acucar;
import com.spindola.atividade_05.model.Canela;
import com.spindola.atividade_05.model.Creme;
import com.spindola.atividade_05.model.Leite;
import com.spindola.atividade_05.model.XaropeBaunilha;
import com.spindola.atividade_05.model.XaropeCaramelo;
import com.spindola.atividade_05.model.enums.TipoAdicionais;
import com.spindola.atividade_05.model.interfaces.ICafe;

public class FabricaDeAdicionais {
    private static FabricaDeAdicionais instancia;

    private FabricaDeAdicionais(){}

    public static FabricaDeAdicionais getInstance(){
        if(instancia == null) {
            instancia = new FabricaDeAdicionais();
        }
        return instancia;
    }

    public ICafe criarAdicional(TipoAdicionais tipo, ICafe cafe){
        switch (tipo) {
            case ACUCAR:
                return new Acucar(cafe);
            case BAUNILHA:
                return new XaropeBaunilha(cafe);
            case CANELA:
                return new Canela(cafe);
            case CREME:
                return new Creme(cafe);
            case LEITE:
                return new Leite(cafe);
            case CARAMELO:
                return new XaropeCaramelo(cafe);
            default:
                throw new IllegalArgumentException("Tipo de adicional inválido: " + tipo);
        }
    }
}
