public class MergeSortDemo {
    static int nivel = 0;

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            nivel++;
            System.out.println("Dividindo no nível " + nivel + ": de " + inicio + " a " + fim);

            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);

            merge(vetor, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            R[j] = vetor[meio + 1 + j];

        int i = 0, j = 0, k = inicio;
        int comparacoes = 0;

        while (i < n1 && j < n2) {
            comparacoes++;
            if (L[i] <= R[j]) {
                vetor[k++] = L[i++];
            } else {
                vetor[k++] = R[j++];
            }
        }

        while (i < n1) vetor[k++] = L[i++];
        while (j < n2) vetor[k++] = R[j++];

        System.out.println("→ Combinando [" + inicio + "," + meio + "] e [" + (meio + 1)
                + "," + fim + "] com " + comparacoes + " comparações");
    }
}
