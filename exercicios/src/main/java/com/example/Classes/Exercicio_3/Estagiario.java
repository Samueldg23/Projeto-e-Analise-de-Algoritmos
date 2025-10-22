package com.example.Classes.Exercicio_3;

public class Estagiario extends Funcionario {

    public Estagiario(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está auxiliando em tarefas simples e aprendendo.");
    }

    @Override
    public double calcularBonificacao() {
        return salario * 0.05; 
    }
}

