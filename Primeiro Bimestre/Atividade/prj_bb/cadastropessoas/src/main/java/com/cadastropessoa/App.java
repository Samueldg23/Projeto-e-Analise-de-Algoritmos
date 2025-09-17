package com.cadastropessoa;

import com.cadastropessoa.dominio.Pessoa;
import com.cadastropessoa.service.PessoaService;
import com.cadastropessoa.service.impl.PessoaServiceVetorial;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PessoaService service = new PessoaServiceVetorial(10);

        service.inserir(new Pessoa(null, "Ana Silva",  "ana@exemplo.com",   28, "11-99999-0001"));
        service.inserir(new Pessoa(null, "Bruno Costa","bruno@exemplo.com", 22, "11-99999-0002"));
        service.inserir(new Pessoa(null, "Ana Souza",  "ana.souza@ex.com",  28, "11-99999-0003"));

        int opcao;
        do {
            System.out.println("\n=== MENU DE CADASTRO DE PESSOAS ===");
            System.out.println("1 - Inserir pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Alterar pessoa");
            System.out.println("6 - Excluir pessoa");
            System.out.println("7 - Ordenar por nome");
            System.out.println("8 - Ordenar por nome e idade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Opção inválida. Digite um número: "); }
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Idade: ");
                    while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Informe idade válida: "); }
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();

                    Pessoa nova = new Pessoa(null, nome, email, idade, celular);
                    service.inserir(nova);
                }
                case 2 -> service.listar();
                case 3 -> {
                    System.out.print("Digite parte do nome: ");
                    String termo = sc.nextLine();
                    Pessoa[] encontrados = service.buscarPorNome(termo);
                    if (encontrados.length == 0) {
                        System.out.println("Nenhum resultado.");
                    } else {
                        for (Pessoa p : encontrados) {
                            System.out.printf("id=%d | nome=%s | email=%s | idade=%d | celular=%s%n",
                                    p.getId(), p.getNome(), p.getEmail(), p.getIdade(), p.getCelular());
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Digite o ID: ");
                    while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Informe um ID válido: "); }
                    int idBusca = sc.nextInt();
                    sc.nextLine();
                    Pessoa p = service.buscarPorId(idBusca);
                    if (p == null) {
                        System.out.println("Pessoa não encontrada.");
                    } else {
                        System.out.printf("Encontrado -> id=%d | nome=%s | email=%s | idade=%d | celular=%s%n",
                                p.getId(), p.getNome(), p.getEmail(), p.getIdade(), p.getCelular());
                    }
                }
                case 5 -> {
                    System.out.print("Digite o ID da pessoa que deseja alterar: ");
                    while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Informe um ID válido: "); }
                    int idAlt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nomeAlt = sc.nextLine();
                    System.out.print("Novo email: ");
                    String emailAlt = sc.nextLine();
                    System.out.print("Nova idade: ");
                    while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Informe idade válida: "); }
                    int idadeAlt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo celular: ");
                    String celularAlt = sc.nextLine();

                    Pessoa alterada = new Pessoa(idAlt, nomeAlt, emailAlt, idadeAlt, celularAlt);
                    service.alterar(alterada);
                }
                case 6 -> {
                    System.out.print("Digite o ID da pessoa que deseja excluir: ");
                    while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Informe um ID válido: "); }
                    int idExc = sc.nextInt();
                    sc.nextLine();
                    service.excluir(idExc);
                }
                case 7 -> {
                    System.out.println("[ORDENAR] Por nome:");
                    service.ordenarPorNome();
                    service.listar();
                }
                case 8 -> {
                    System.out.println("[ORDENAR] Por nome e idade:");
                    service.ordenarPorNomeEIdade();
                    service.listar();
                }
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
