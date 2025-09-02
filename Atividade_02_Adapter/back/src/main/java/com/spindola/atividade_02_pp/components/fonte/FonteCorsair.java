package com.spindola.atividade_02_pp.components.fonte;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IFonteAlimentacao;

public class FonteCorsair implements IFonteAlimentacao{
    private Integer id;
    private String fabricante;
    private Integer voltagem;
    private TipoConector tipoConector;

    public FonteCorsair(){
        id = 001;
        fabricante = "Corsair";
        voltagem = 12;
        tipoConector = TipoConector.MQ88;
    }

    @Override
    public Integer getId(){
        return id;
    };

    public String getFabricante(){
        return fabricante;
    }

    public Integer getTaxaVoltagem(){
        return voltagem;
    }
    
    @Override
    public String fornecerEnergia() {
        return fabricante + " fornecendo energia de " + voltagem + "V";
    }

    @Override
    public TipoConector getTipoConector() {
        return tipoConector;
    }

    @Override
    public String toString() {
        return "Fabricante: " + fabricante +
            "\n - Voltagem: " + voltagem + " V" +
            "\n - Tipo de Conector: " + tipoConector;
    }
}
