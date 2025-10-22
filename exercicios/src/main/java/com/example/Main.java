package com.example;

import com.example.Classes.Exercicio_1.Animal;
import com.example.Classes.Exercicio_1.Cachorro;
import com.example.Classes.Exercicio_1.Gato;
import com.example.Classes.Exercicio_2.Carro;
import com.example.Classes.Exercicio_2.Moto;
import com.example.Classes.Exercicio_2.Veiculo;
import com.example.Classes.Exercicio_3.Desenvolvedor;
import com.example.Classes.Exercicio_3.Estagiario;
import com.example.Classes.Exercicio_3.Funcionario;
import com.example.Classes.Exercicio_3.Gerente;

public class Main {
    public static void main(String[] args) {
        // bloco do Exercício 1
        System.out.println("=== Teste de Animais ===");
        Animal cachorro = new Cachorro("Rex", 3);
        Animal gato = new Gato("Mimi", 2);

        cachorro.emitirSom();
        cachorro.dormir();

        gato.emitirSom();
        gato.dormir();

        // bloco do Exercício 2
        Veiculo carro = new Carro("Civic");
        Veiculo moto = new Moto("Hornet");

        System.out.println("\n=== Teste de Veículos ===");
        carro.abastecer(30);
        carro.acelerar();
        carro.frear();

        moto.abastecer(10);
        moto.acelerar();
        moto.frear();

        // bloco do Exercício 3
        System.out.println("\n=== Teste de Funcionários ===");

        Funcionario dev = new Desenvolvedor("Alice", 5000);
        Funcionario gerente = new Gerente("Bruno", 8000);
        Funcionario estagiario = new Estagiario("Carlos", 1500);

        Funcionario[] funcionarios = { dev, gerente, estagiario };

        for (Funcionario f : funcionarios) {
            f.trabalhar();
            System.out.println("Bonificação de " + f.getNome() + ": R$ " + f.calcularBonificacao());
            System.out.println();
        }

    }
}
