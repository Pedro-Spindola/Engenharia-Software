package com.spindola.atividade_02_pp.components.chipset;

import com.spindola.atividade_02_pp.enums.TipoConector;
import com.spindola.atividade_02_pp.interfaces.IChipset;

public class ChipsetQualcomm implements IChipset{
    private Integer id;
    private String modelo;
    private double velocidadeClock;
    private TipoConector tipoConector;

    public ChipsetQualcomm(){
        id = 001;
        modelo = "Qualcomm - Q2Z1";
        velocidadeClock = 800;
        tipoConector = TipoConector.P3;
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
