package com.spindola;

public class Moto extends Veiculo {
    private Integer cilindrada;
    private Boolean temBau;

    public Moto(String marca, String modelo, int ano, String cor, Integer cilindrada, Boolean temBau) {
        super(marca, modelo, ano, cor);
        this.cilindrada = cilindrada;
        this.temBau = temBau;
    }

    @Override
    public void acelerar() {
        System.out.println("A moto está acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("A moto está freando...");
    }

    @Override
    public void abastecer() {
        System.out.println("A moto está sendo abastecida...");
    }

    public void empinar() {
        System.out.println("A moto está empinando!");
    }

    // Getters e Setters
    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Boolean getTemBau() {
        return temBau;
    }

    public void setTemBau(Boolean temBau) {
        this.temBau = temBau;
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Moto [cilindrada=" + cilindrada +
               ", temBau=" + temBau + "]";
    }
}
