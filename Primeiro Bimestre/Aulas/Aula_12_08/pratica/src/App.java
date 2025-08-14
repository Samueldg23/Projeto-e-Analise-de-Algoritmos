public class App {
    public static void main(String[] args) {
        int[] vetor = { 8,7,6,5,4,3,2,1};

        System.out.println("Vetor original:");
        for (int v : vetor)
            System.out.print(v + " ");
        System.out.println("\n");

        MergeSortDemo.mergeSort(vetor, 0, vetor.length - 1);

        System.out.println("\nVetor ordenado:");
        for (int v : vetor)
            System.out.print(v + " ");
    }
}