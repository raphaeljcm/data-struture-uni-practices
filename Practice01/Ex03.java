package Practice01;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        Random num = new Random();
        Scanner scan = new Scanner(System.in);
        int aux, value;

        System.out.println("Vetor desorganizado");
        for(int i = 0; i < 10; i++) {
            vetor[i] = num.nextInt(100);
            System.out.print(" " + vetor[i]);
        }

        for(int i = 0; i<10; i++) {
            for(int j = 0; j<9; j++) {
                if(vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }

        System.out.println();
        System.out.println("Vetor organizado");
        for(int i = 0; i < 10; i++) {
            System.out.print(" " + vetor[i]);
        }

        System.out.println();
        System.out.print("Digite o valor a ser buscado: ");
        value = scan.nextInt();

        System.out.println();
        System.out.println("BUSCA BINÁRIA");
        pesquisaBinaria(value, vetor);

        scan.close();
    }

    public static void pesquisaBinaria(int x, int[] numeros) {
        int inicio = 0;
        int meio = 0;
        int fim = numeros.length - 1;

    /* Enquanto a posição do inicio for menor ou igual a posição do fim,
      procura o valor de x dentro do vetor. */
        while(inicio <= fim) {
            meio = (fim + inicio) / 2; //Encontra o meio do vetor.

            System.out.println("Inicio: " + numeros[inicio] + " - Meio: " + numeros[meio] + " - Fim: " + numeros[fim]);

      /* Se o valor que está no meio do vetor é igual ao valor procurado,
        imprime que encontrou o valor e para de pesquisar. */
            if(numeros[meio] == x) {
                System.out.println("Encontrou o número " + x);
                break;
            }

            /* Este if serve para diminuir o tamanho do vetor pela métade. */
      /* Se o valor que está no meio do vetor for menor que o valor de x,
        então o inicio do vetor será igual a posição do meio + 1. */
            if(numeros[meio] < x) {
                inicio = meio + 1;
            } else {
        /* Se o valor que está no meio do vetor for maior que o valor de x,
          então o fim do vetor será igual a posição do meio - 1. */
                fim = meio - 1;
            }
        }

    /* Caso não encontre o valor pesquisado dentro do vetor,
      imprime que não encontrou o valor pesquisado. */
        if(inicio > fim) {
            System.out.println("Não encontrou o número " + x);
        }
    }
}
