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
            array[j + 1] = chave;
        }
    }
}
