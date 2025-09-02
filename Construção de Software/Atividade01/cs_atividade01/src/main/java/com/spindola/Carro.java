package com.spindola;

public class Carro extends Veiculo{
    private Integer quantidadePortas;
    private Integer capacidadePortaMalas;

    public Carro(String marca, String modelo, int ano, String cor, Integer quantidadePortas, Integer capacidadePortaMalas) {
        super(marca, modelo, ano, cor);
        this.quantidadePortas = quantidadePortas;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("O carro está freando...");
    }

    @Override
    public void abastecer() {
        System.out.println("O carro está sendo abastecido...");
    }

    public void abrirPortaMalas() {
        System.out.println("Abrindo porta-malas do carro...");
    }

    public void ligarArCondicionado() {
        System.out.println("Ar-condicionado ligado!");
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public Integer getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(Integer capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    @Override
    public String toString() {
        return super.toString() + 
               " | Carro [quantidadePortas=" + quantidadePortas + 
               ", capacidadePortaMalas=" + capacidadePortaMalas + "]";
    }
}
