package algoritmos;


//!https://www.youtube.com/watch?v=RxDK2sgwWUk&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha&index=14
//!https://www.youtube.com/watch?v=g63dqkcDOG4&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha&index=15
//?https://www.youtube.com/watch?v=bOk35XmHPKs
public class MergeSort implements Ordenador {

    @Override
    public void ordenar(int[] array) {
        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] aux, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, aux, left, mid);
            mergeSort(array, aux, mid + 1, right);
            merge(array, aux, left, mid, right);
        }
    }

    private void merge(int[] array, int[] aux, int left, int mid, int right) {
        for (int k = left; k <= right; k++) {
            aux[k] = array[k];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }

        while (i <= mid) {
            array[k++] = aux[i++];
        }

    }
}