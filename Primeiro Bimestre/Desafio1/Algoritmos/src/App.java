import gerador.GeradorArquivo;
import algoritmos.BubbleSort;
import algoritmos.InsertionSort;
import algoritmos.Ordenador;
import algoritmos.SelectionSort;

import java.io.*;
import java.util.*;

//! https://www.youtube.com/watch?v=_HBTCUNPxOg&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha




public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String basePath = System.getProperty("user.dir") + File.separator + "dados";
        String caminhoEntrada;
        String caminhoSaida;

        System.out.println("Deseja gerar um arquivo novo? (s/n)");
        String opcao = sc.nextLine();

        if (opcao.equalsIgnoreCase("s")) {
            System.out.print("Digite a quantidade de números: ");
            int qtd = sc.nextInt();
            sc.nextLine();

            System.out.print("Tipo (crescente / decrescente / aleatorio): ");
            String tipo = sc.nextLine();

            System.out.print("Com repetição? (true/false): ");
            boolean repeticao = sc.nextBoolean();
            sc.nextLine(); // limpar buffer

            System.out.print("Digite o nome do arquivo (sem .txt): ");
            String nomeArquivo = sc.nextLine();

            caminhoEntrada = basePath + File.separator + "entrada" + File.separator + nomeArquivo + ".txt";
            GeradorArquivo.gerarArquivo(caminhoEntrada, qtd, tipo, repeticao);
        } else {
            System.out.print("Digite o nome do arquivo de entrada (sem .txt): ");
            String nomeArquivo = sc.nextLine();
            caminhoEntrada = basePath + File.separator + "entrada" + File.separator + nomeArquivo + ".txt";
        }

        int[] numeros = carregarNumeros(caminhoEntrada);

        System.out.println("\nEscolha o algoritmo de ordenação:");
        System.out.println("1 - BubbleSort");
        System.out.println("2 - InsertionSort");
        System.out.println("3 - SelectionSort");
        int escolha = sc.nextInt();
        sc.nextLine();

        Ordenador ordenador;
        String nomeAlgoritmo;

        switch (escolha) {
            case 1:
                ordenador = new BubbleSort();
                nomeAlgoritmo = "BubbleSort";
                break;
            case 2:
                ordenador = new InsertionSort();
                nomeAlgoritmo = "InsertionSort";
                break;
            case 3:
                ordenador = new SelectionSort();
                nomeAlgoritmo = "SelectionSort";
                break;
            default:
                System.out.println("Opção inválida.");
                sc.close();
                return;
        }

        System.out.print("Digite o nome do arquivo de saída (sem .txt): ");
        String nomeSaida = sc.nextLine();
        caminhoSaida = basePath + File.separator + "saida" + File.separator + nomeSaida + ".txt";

        long inicio = System.nanoTime();
        ordenador.ordenar(numeros);
        long fim = System.nanoTime();

        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("Tempo de execução (" + nomeAlgoritmo + "): " + tempoMs + " ms");

        salvarNumeros(caminhoSaida, numeros);
        System.out.println("Arquivo ordenado salvo em: " + caminhoSaida);

        sc.close();
    }

    private static int[] carregarNumeros(String caminho) throws IOException {
        List<Integer> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Integer.parseInt(linha.trim()));
            }
        }
        return lista.stream().mapToInt(i -> i).toArray();
    }

    private static void salvarNumeros(String caminho, int[] numeros) throws IOException {
        File file = new File(caminho);
        try (FileWriter fw = new FileWriter(file)) {
            for (int num : numeros) {
                fw.write(num + "\n");
            }
        }
    }
}
