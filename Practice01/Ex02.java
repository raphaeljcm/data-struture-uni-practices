package Practice01;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        int[][] matriz = new int[3][4];
        Random nums = new Random();
        int maxValue= Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int linhas = 0; linhas < 3; linhas++) {
            for(int cols = 0; cols < 4; cols++) {
                matriz[linhas][cols] = nums.nextInt(100);

                if(matriz[linhas][cols] > maxValue) {
                    maxValue = matriz[linhas][cols];
                }

                if(matriz[linhas][cols] < minValue) {
                    minValue = matriz[linhas][cols];
                }

                System.out.print(matriz[linhas][cols] + "\t");
            }

            System.out.println();
        }

        System.out.println("O maior valor da matriz: " + maxValue);
        System.out.println("O menor valor da matriz: " + minValue);
    }
}
