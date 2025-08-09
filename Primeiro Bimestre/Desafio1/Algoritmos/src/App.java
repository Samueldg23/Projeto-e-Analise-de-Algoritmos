import gerador.GeradorArquivo;
import algoritmos.BubbleSort;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja gerar um arquivo novo? (s/n)");
        String opcao = sc.nextLine();

        String caminhoEntrada;

        if (opcao.equalsIgnoreCase("s")) {
            System.out.print("Digite a quantidade de números: ");
            int qtd = sc.nextInt();
            sc.nextLine();

            System.out.print("Tipo (crescente / decrescente / aleatorio): ");
            String tipo = sc.nextLine();

            System.out.print("Com repetição? (true/false): ");
            boolean repeticao = sc.nextBoolean();

            caminhoEntrada = "dados/entrada/arquivo_" + tipo + "_" + qtd + ".txt";
            GeradorArquivo.gerarArquivo(caminhoEntrada, qtd, tipo, repeticao);
        } else {
            System.out.print("Digite o nome do arquivo na pasta dados/entrada: ");
            String nomeArquivo = sc.nextLine();
            caminhoEntrada = "dados/entrada/" + nomeArquivo + ".txt";
        }

        int[] numeros = carregarNumeros(caminhoEntrada);

        BubbleSort bubble = new BubbleSort();
        long inicio = System.nanoTime();
        bubble.ordenar(numeros);
        long fim = System.nanoTime();

        long tempoMs = (fim - inicio) / 1_000_000;
        System.out.println("Tempo de execução (BubbleSort): " + tempoMs + " ms");

        String caminhoSaida = "dados/saida/ordenado_bubble.txt";
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
