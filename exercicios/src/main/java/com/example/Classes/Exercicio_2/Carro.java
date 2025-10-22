package com.example.Classes.Exercicio_2;

public class Carro implements Veiculo {
    private String modelo;
    private double velocidadeAtual;
    private double tanque;

    public Carro(String modelo) {
        this.modelo = modelo;
        this.velocidadeAtual = 0;
        this.tanque = 0;
    }

    @Override
    public void acelerar() {
        velocidadeAtual += 10;
        System.out.println(modelo + " acelerando... Velocidade: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        velocidadeAtual = Math.max(velocidadeAtual - 5, 0);
        System.out.println(modelo + " freando... Velocidade: " + velocidadeAtual + " km/h");
    }

    @Override
    public void abastecer(double litros) {
        tanque += litros;
        System.out.println(modelo + " abastecido com " + litros + " litros. Total: " + tanque + "L");
    }
}
