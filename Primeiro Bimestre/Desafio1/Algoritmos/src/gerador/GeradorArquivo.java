package gerador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GeradorArquivo {

    public static void gerarArquivo(String caminho, int quantidade, String tipo, boolean repeticao) throws IOException {
        int[] numeros = new int[quantidade];

        if (tipo.equalsIgnoreCase("crescente")) {
            for (int i = 0; i < quantidade; i++) {
                numeros[i] = repeticao ? i % 1000 : i;
            }
        } else if (tipo.equalsIgnoreCase("decrescente")) {
            for (int i = 0; i < quantidade; i++) {
                numeros[i] = repeticao ? (quantidade - i) % 1000 : quantidade - i;
            }
        } else if (tipo.equalsIgnoreCase("aleatorio")) {
            Random random = new Random();
            if (repeticao) {
                for (int i = 0; i < quantidade; i++) {
                    numeros[i] = random.nextInt(quantidade);
                }
            } else {
                List<Integer> lista = new ArrayList<>();
                for (int i = 0; i < quantidade; i++) lista.add(i);
                Collections.shuffle(lista);
                for (int i = 0; i < quantidade; i++) numeros[i] = lista.get(i);
            }
        }

        // Criar o arquivo e a pasta se não existir
        File file = new File(caminho);
        file.getParentFile().mkdirs(); //aqui cria as pastas se elas não existirem

        try (FileWriter writer = new FileWriter(file)) {
            for (int num : numeros) {
                writer.write(num + "\n");
            }
        }

        System.out.println("Arquivo gerado com sucesso: " + file.getAbsolutePath());
    }
}
