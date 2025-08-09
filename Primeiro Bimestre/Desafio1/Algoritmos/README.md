# 📚 Projeto de Algoritmos de Ordenação em Java

Este projeto implementa diversos algoritmos de ordenação (Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort e Heap Sort) em **Java**, com entrada e saída de arquivos via terminal.  
O objetivo é permitir a geração de arquivos com números, a seleção de um algoritmo de ordenação e a medição do tempo de execução (benchmark).
Para a medição do benchmark será testado pelo menos 3 vezes cada ordenador e fazer uma média do tempo que o algoritmo levou para ordenar o arquivo.
Será feito esses conjuntos de dados:
- Crescente com repetição
- Decrescente com repetição
- Aleatório com repetição
- Crescente sem repetição
- Decrescente sem repetição
- Aleatório sem repetição
---

## 📂 Estrutura de Pastas
```plaintext
/
├── dados/
│   ├── entrada/     # Arquivos de entrada com números a serem ordenados
│   └── saida/       # Arquivos de saída com números ordenados
├── src/
│   ├── algoritmos/  # Implementações dos algoritmos de ordenação
│   │   ├── Ordenador.java
│   │   ├── BubbleSort.java
│   │   ├── InsertionSort.java
│   │   ├── SelectionSort.java
│   │   ├── MergeSort.java
│   │   ├── QuickSort.java
│   │   └── HeapSort.java
│   ├── gerador/     # Classe para geração de arquivos de números
│   │   └── GeradorArquivo.java
│   └── App.java     # Classe principal com menu e execução
└── README.md

