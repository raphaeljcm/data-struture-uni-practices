package av1;

public class Pergunta_01 {
    public static void main(String[] args) {
        int[] vetor = {3,8,7,9,10,11,80,2,1,50};

        for(int i = 0; i < 9; i++) {
            int value = vetor[i];
            int j = i - 1;

            while((j >= 0) && (value < vetor[j])) {
                int temp = vetor[j + 1];
                vetor[j + 1] = vetor[j];
                vetor[j] = temp;
                j--;

                if(j == -1) {
                    break;
                }
            }
        }

        for(int t:vetor) {
            System.out.printf("%d \t", t);
        }
    }
}
