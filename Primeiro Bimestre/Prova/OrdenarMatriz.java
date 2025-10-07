public class OrdenarMatriz {
    public static void ordenarColunas(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }

            bubbleSort(coluna);

            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
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