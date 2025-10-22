package com.example.Classes.Exercicio_3;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está desenvolvendo código e corrigindo bugs.");
    }

    @Override
    public double calcularBonificacao() {
        return salario * 0.15; // 15% de bônus
    }
}

