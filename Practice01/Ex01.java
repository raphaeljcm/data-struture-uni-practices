package Practice01;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        boolean aux = false;
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor de um a 100: ");
        int value = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            vetor[i] = random.nextInt(10);
        }

        for (int i = 0; i < 10; i++) {
            if (vetor[i] == value) {
                System.out.println(i);
                aux = true;
            }
        }

        if (aux == false) {
            System.out.println("Valor não encontrado.");
        }

        sc.close();
    }
}
