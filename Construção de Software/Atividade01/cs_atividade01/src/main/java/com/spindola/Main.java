package com.spindola;

public class Main {
    public static void main(String[] args) {
        
        Carro carro = new Carro("Toyota", "Corolla", 2022, "Prata", 4, 470);
        System.out.println(carro.toString());
        carro.acelerar();
        carro.frear();
        carro.abastecer();
        carro.abrirPortaMalas();
        carro.ligarArCondicionado();

        System.out.println("\n---\n");

        Moto moto = new Moto("Honda", "CB 500", 2021, "Vermelha", 500, true);
        System.out.println(moto.toString());
        moto.acelerar();
        moto.frear();
        moto.abastecer();
        moto.empinar();

        System.out.println("\n---\n");

        Caminhao caminhao = new Caminhao("Scania", "R450", 2020, "Branco", 30, "Baú", 6);
        System.out.println(caminhao.toString());
        caminhao.acelerar();
        caminhao.frear();
        caminhao.abastecer();
        caminhao.engatarReboque();
        caminhao.desengatarReboque();
    }
}
