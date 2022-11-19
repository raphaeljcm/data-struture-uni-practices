package Practice07;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        System.out.println("Random Binary Search Tree with Balanced");
        Tree tree = chooseParams();
        Scanner scan = new Scanner(System.in);
        char ch;

        do {
            System.out.println("***********************************");
            System.out.println("Entre com a opcao:");
            System.out.println("1. Menor elemento");
            System.out.println("2. Maior elemento");
            System.out.println("3. Árvores são idênticas?");
            System.out.println("4. Altura");
            System.out.println("5. Está balanceada?");
            System.out.println("***********************************");
            System.out.print("-> ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Menor elemento: " + tree.min());
                case 2 -> System.out.println("Maior elemento: " + tree.max());
                case 3 -> {
                    System.out.println("Preencha uma nova árvore para comparar");
                    Tree tree2 = chooseParams();
                    System.out.println("Idênticas: " + tree.equals(tree2));
                }
                case 4 -> System.out.println("Altura: " + tree.height());
                case 5 -> System.out.println("Balanceada: " + tree.isBalanced());
                default -> System.out.println("Opção inválida.");
            }

            System.out.println("\nVocê deseja continuar? (Insira s ou n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'S'|| ch == 's');

        sc.close();
    }

    private static Tree chooseParams() {
        int maxValueAllowed, amount;
        Tree binaryTree = new Tree();

        System.out.print("Quantos elementos deseja inserir na árvore: ");
        amount = sc.nextInt();
        System.out.print("Valor máximo permitido [INTEGER]: ");
        maxValueAllowed = sc.nextInt();
        fillTree(binaryTree,amount,maxValueAllowed);

        return binaryTree;
    }

    private static void fillTree(Tree binaryTree, int amount, int maxValueAllowed) {
        Random random = new Random();
        int num;
        System.out.println();
        while (amount > 0) {
            num = random.nextInt(maxValueAllowed);
            binaryTree.insert(num);
            System.out.println("Valor inserido: " + num);
            amount--;
        }
        System.out.println();
    }
}
