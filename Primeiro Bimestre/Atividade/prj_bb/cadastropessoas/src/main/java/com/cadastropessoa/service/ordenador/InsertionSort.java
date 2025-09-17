package com.cadastropessoa.service.ordenador;


import com.cadastropessoa.dominio.Pessoa;


import java.util.Comparator;

public final class InsertionSort {

  private InsertionSort() {}

    public static void ordenar(Pessoa[] vetor, int tamanho, Comparator<Pessoa> cmp) {
        for (int i = 1; i < tamanho; i++) {
            Pessoa chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && cmp.compare(vetor[j], chave) > 0) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }
}

