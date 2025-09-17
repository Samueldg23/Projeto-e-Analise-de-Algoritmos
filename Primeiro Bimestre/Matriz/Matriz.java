public class Matriz {
    public static void main(String[] args) {
        int[][] matriz = {
            {9, 2, 7},
            {4, 6, 1},
            {8, 3, 5}
        };
        // uma espécie de bubble sort
        for (int i = 0; i < matriz.length; i++) {    
            for (int j = 0; j < matriz[i].length - 1; j++) { 
                for (int k = j + 1; k < matriz[i].length; k++) {
                    if (matriz[i][j] > matriz[i][k]) {
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[i][k];
                        matriz[i][k] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
