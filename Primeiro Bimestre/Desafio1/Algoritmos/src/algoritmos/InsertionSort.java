package algoritmos;

//!https://www.youtube.com/watch?v=pfCjJqTKvFY&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha&index=10

public class InsertionSort implements Ordenador {

    @Override
    public void ordenar(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int chave = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }
//* Verifica se houve movimentação de elementos antes de inserir a chave.
//* Caso não tenha havido, o elemento já estava na posição correta,
//* evita uma atribuição desnecessária, melhorando a eficiência no melhor caso (O(n)).
            if (j + 1 != i) {
                array[j + 1] = chave;
            }
        }
    }
}
