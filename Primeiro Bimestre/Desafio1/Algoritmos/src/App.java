import gerador.GeradorArquivo;
import algoritmos.BubbleSort;
import algoritmos.InsertionSort;
import algoritmos.Ordenador;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String basePath = System.getProperty("user.dir") + "/dados";
        String caminhoEntrada;

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

            caminhoEntrada = basePath + "/entrada/arquivo_" + tipo + "_" + qtd + ".txt";
            GeradorArquivo.gerarArquivo(caminhoEntrada, qtd, tipo, repeticao);
        } else {
            System.out.print("Digite o nome do arquivo na pasta dados/entrada (sem .txt): ");
            String nomeArquivo = sc.nextLine();
            caminhoEntrada = basePath + "/entrada/" + nomeArquivo + ".txt";
        }

        int[] numeros = carregarNumeros(caminhoEntrada);

        System.out.println("\nEscolha o algoritmo de ordenação:");
        System.out.println("1 - BubbleSort");
        System.out.println("2 - InsertionSort");
        int escolha = sc.nextInt();

        Ordenador ordenador;
        String nomeAlgoritmo;
        String caminhoSaida;
        // depois usar o switch
        if (escolha == 1) {
            ordenador = new BubbleSort();
            nomeAlgoritmo = "BubbleSort";
            caminhoSaida = basePath + "/saida/ordenado_bubble.txt";
        } else {
            ordenador = new InsertionSort();
            nomeAlgoritmo = "InsertionSort";
            caminhoSaida = basePath + "/saida/ordenado_insertion.txt";
        }

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
        file.getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(file)) {
            for (int num : numeros) {
                fw.write(num + "\n");
            }
        }
    }
}
