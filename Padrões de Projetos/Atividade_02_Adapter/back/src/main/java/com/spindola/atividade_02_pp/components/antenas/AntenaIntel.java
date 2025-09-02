package com.spindola.atividade_02_pp.components.antenas;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IAntena;

public class AntenaIntel implements IAntena{
    private Integer id;
    private String modelo;
    private double dBi;
    private double frequencia;
    private TipoConector tipoConector;

    public AntenaIntel(){
        id = 002;
        modelo = "Intel AI82";
        dBi = 7;
        frequencia = 8.0;
        tipoConector = TipoConector.TRJ9;
    }

    @Override
    public Integer getId(){
        return id;
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

    @Override
    public String toString() {
        return "Modelo: " + modelo +
            "\n - dBi: " + dBi +
            "\n - Frequência: " + frequencia + " GHz" +
            "\n - Tipo de Conector: " + tipoConector;
    }
}
