package com.spindola.atividade_02_pp.components.chipset;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IChipset;

public class ChipsetRealtek implements IChipset{
    private Integer id;
    private String modelo;
    private double velocidadeClock;
    private TipoConector tipoConector;

    public ChipsetRealtek(){
        id = 002;
        modelo = "Realtek - RLT7";
        velocidadeClock = 700;
        tipoConector = TipoConector.XJ;
    }

    @Override
    public Integer getId(){
        return id;
    };

    public String getModelo(){
        return modelo;
    }

    public double getVelocidadeClock(){
        return velocidadeClock;
    }
    
    @Override
    public String processarDados() {
        return modelo + " processando dados a " + velocidadeClock + " MHz";
    }

    @Override
    public TipoConector getTipoConector() {
        return tipoConector;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo +
            "\n - Clock: " + velocidadeClock + " MHz" +
            "\n - Tipo de Conector: " + tipoConector;
    }
}
