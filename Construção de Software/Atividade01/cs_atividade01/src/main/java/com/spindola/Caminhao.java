package com.spindola;

public class Caminhao extends Veiculo {
    private Integer capacidadeCarga;
    private String tipoCarroceria;
    private Integer numeroEixos;

    public Caminhao(String marca, String modelo, int ano, String cor, Integer capacidadeCarga, String tipoCarroceria, Integer numeroEixos) {
        super(marca, modelo, ano, cor);
        this.capacidadeCarga = capacidadeCarga;
        this.tipoCarroceria = tipoCarroceria;
        this.numeroEixos = numeroEixos;
    }

    @Override
    public void acelerar() {
        System.out.println("O caminhão está acelerando pesado...");
    }

    @Override
    public void frear() {
        System.out.println("O caminhão está freando com freio motor...");
    }

    @Override
    public void abastecer() {
        System.out.println("O caminhão está sendo abastecido com diesel...");
    }

    public void engatarReboque() {
        System.out.println("Reboque engatado!");
    }

    public void desengatarReboque() {
        System.out.println("Reboque desengatado!");
    }

    public Integer getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(Integer capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public Integer getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(Integer numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Caminhao [capacidadeCarga=" + capacidadeCarga +
               " toneladas, tipoCarroceria=" + tipoCarroceria +
               ", numeroEixos=" + numeroEixos + "]";
    }
}
