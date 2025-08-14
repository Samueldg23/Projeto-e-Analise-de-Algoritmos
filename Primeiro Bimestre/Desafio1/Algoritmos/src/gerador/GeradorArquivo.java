package gerador;

//!https://www.youtube.com/watch?v=572A_N8h_Xs
//?https://www.youtube.com/watch?v=oNnN2dHEoo8

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GeradorArquivo {

    public static void gerarArquivo(String caminho, int quantidade, String tipo, boolean repeticao) throws IOException {
        int[] numeros = new int[quantidade];
        int repeticoes = 3;

        if (tipo.equalsIgnoreCase("crescente")) {
            for (int i = 0; i < quantidade; i++) {
                if (repeticao) {
                    numeros[i] = i / repeticoes;
                } else {
                    numeros[i] = i;
                }
            }
        } else if (tipo.equalsIgnoreCase("decrescente")) {
            for (int i = 0; i < quantidade; i++) {
                if (repeticao) {
                    numeros[i] = (quantidade - 1 - i) / repeticoes;
                } else {
                    numeros[i] = quantidade - 1 - i;
                }
            }
        } else if (tipo.equalsIgnoreCase("aleatorio")) {
            Random random = new Random();
            if (repeticao) {
                for (int i = 0; i < quantidade; i++) {
                    numeros[i] = random.nextInt((quantidade + repeticoes - 1) / repeticoes);
                }
            } else {
                List<Integer> lista = new ArrayList<>();
                for (int i = 0; i < quantidade; i++)
                    lista.add(i);
                Collections.shuffle(lista);
                for (int i = 0; i < quantidade; i++)
                    numeros[i] = lista.get(i);
            }
        }

        File file = new File(caminho);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            for (int num : numeros) {
                writer.write(num + "\n");
            }
        }

        System.out.println("Arquivo gerado com sucesso: " + file.getAbsolutePath());
    }
}
