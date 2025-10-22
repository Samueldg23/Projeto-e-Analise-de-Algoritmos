package com.example.Classes.Exercicio_3;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está gerenciando a equipe e revisando metas.");
    }

    @Override
    public double calcularBonificacao() {
        return salario * 0.30;
    }
}

