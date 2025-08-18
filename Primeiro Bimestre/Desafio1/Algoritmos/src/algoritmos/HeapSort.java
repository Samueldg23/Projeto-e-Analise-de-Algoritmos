package algoritmos;


//!https://www.youtube.com/watch?v=m_H7bBNC35I&list=PLncEdvQ20-mgGanwuFczm-4IwIdIcIiha&index=25
//?https://www.youtube.com/watch?v=5FGH28zZSd0
// *https://www.youtube.com/watch?v=2DmK_H7IdTo&t=228s


public class HeapSort implements Ordenador {

    @Override
    public void ordenar(int[] array) {
        heapSort(array);
    }

    private void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}
