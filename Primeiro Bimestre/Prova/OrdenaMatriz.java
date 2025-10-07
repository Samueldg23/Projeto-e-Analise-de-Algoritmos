
public class OrdenaMatriz {

    public static void ordenarMatriz(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int[] vetor = new int[linhas * colunas];
        int k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[k++] = matriz[i][j];
            }
        }

        bubbleSort(vetor);

        k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[k++];
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou)
                break;
        }
    }
}
