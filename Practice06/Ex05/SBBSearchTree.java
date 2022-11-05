package Practice06.Ex05;
import java.util.Scanner;

public class SBBSearchTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* Creating object of SelfBalancingBinarySearchTree */
        SBBTree sbbst = new SBBTree();
        System.out.println("Programa Arvore Binaria Balanceada\n");

        char ch;

        /*  Perform tree operations  */
        do {
            System.out.println("\nEntre com a opcao:\n");
            System.out.println("1. Inserir ");
            System.out.println("2. Pesquisar");
            System.out.println("3. Contar nos");
            System.out.println("4. Checar se esta vazio");
            System.out.println("5. Limpar arvore");

            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Insira um numero inteiro");
                    sbbst.insert(scan.nextInt());
                }
                case 2 -> {
                    System.out.println("Insira um numero inteiro para pesquisar");
                    System.out.println("Resultado da pesquisa: " + sbbst.search(scan.nextInt()));
                }
                case 3 -> System.out.println("Nos = " + sbbst.countNodes());
                case 4 -> System.out.println("Status = " + sbbst.isEmpty());
                case 5 -> {
                    System.out.println("\nArvore limpa!");
                    sbbst.clear();
                }
                default -> System.out.println("Voce inseriu algo errado \n ");
            }

            /*  Display tree  */
            System.out.print("\nPos ordem : ");
            sbbst.postorder();
            System.out.print("\nPre ordem : ");
            sbbst.preorder();
            System.out.print("\nEm ordem : ");
            sbbst.inorder();

            System.out.println("\nVocê deseja continuar? (Insira s ou n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'S'|| ch == 's');
    }
}
