package algoritmos;

//!https://www.youtube.com/watch?v=FUlmg8HsF4k&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha&index=24
//?https://www.youtube.com/watch?v=KvuzSVZAsxg

public class SelectionSort implements Ordenador {

    @Override
    public void ordenar(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}