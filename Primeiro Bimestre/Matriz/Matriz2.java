public class Matriz2 {
    public static void main(String[] args) {
        int[][] matriz = {
            {9, 2, 7},
            {4, 6, 1},
            {8, 3, 5}
        };

        int linhas = matriz.length;
        int colunas = matriz[0].length;
        //bubble invertido j pelo i
        for (int j = 0; j < colunas; j++) {
            for (int i = 0; i < linhas - 1; i++) { 
                for (int k = i + 1; k < linhas; k++) {
                    if (matriz[i][j] > matriz[k][j]) {
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[k][j];
                        matriz[k][j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
