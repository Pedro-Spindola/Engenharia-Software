package com.spindola.atividade_02_pp.components.antenas;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IAntena;

public class AntenaHuawei implements IAntena{
    private Integer id;
    private String modelo;
    private double dBi;
    private double frequencia;
    private TipoConector tipoConector;

    public AntenaHuawei(){
        id = 001;
        modelo = "Huawei H6-P";
        dBi = 9;
        frequencia = 8.0;
        tipoConector = TipoConector.LPX;
    }

    @Override
    public Integer getId(){
        return id;
    };

    @Override
    public String transmitirSinal(){
        return modelo + " transmitindo sinal com ganho de " + dBi + " dBi";
    };

    @Override
    public String receberSinal(){
        return modelo + " recebendo sinal na frequência de " + frequencia + " GHz";
    };

    @Override
    public TipoConector getTipoConector(){
        return tipoConector;
    };

    public String getModelo(){
        return modelo;
    }

    public double getdBi(){
        return dBi;
    }

    public double getFrequencia(){
        return frequencia;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo +
            "\n - dBi: " + dBi +
            "\n - Frequência: " + frequencia + " GHz" +
            "\n - Tipo de Conector: " + tipoConector;
    }
}
