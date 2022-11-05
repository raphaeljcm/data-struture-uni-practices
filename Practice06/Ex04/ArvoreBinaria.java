package Practice06.Ex04;

import Practice06.Ex05.SBBTree;

import java.util.Scanner;

public class ArvoreBinaria {
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Tree arv = new Tree();
        SBBTree sbbst = new SBBTree();
        BinarySearchTree<Integer> drawBinaryTree = new BinarySearchTree<>();
        int opcao;
        long x;

        System.out.print("\n Programa Arvore binaria de long");

        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----1: Inserir");
            System.out.print("\n ----2: Excluir");
            System.out.print("\n ----3: Pesquisar");
            System.out.print("\n ----4: Exibir");
            System.out.print("\n ----5: Exibir arvore balanceada");
            System.out.print("\n ----6: Desenhar arvore binaria");
            System.out.print("\n ----7: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = le.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = le.nextLong();
                    arv.inserir(x);
                    sbbst.insert(Math.toIntExact(x));
                    drawBinaryTree.add(Math.toIntExact(x));
                }
                case 2 -> {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = le.nextLong();
                    if (!arv.remover(x))
                        System.out.print("\n Valor nao encontrado!");
                }
                case 3 -> {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = le.nextLong();
                    if (arv.buscar(x) != null)
                        System.out.print("\n Valor Encontrado");
                    else
                        System.out.print("\n Valor nao encontrado!");
                }
                case 4 -> {
                    arv.caminhar();
                }
                case 5 -> {
                    System.out.print("\nPos ordem : ");
                    sbbst.postorder();
                    System.out.print("\nPre ordem : ");
                    sbbst.preorder();
                    System.out.print("\nEm ordem : ");
                    sbbst.inorder();
                    System.out.println();
                }
                case 6 -> {
                    DrawBinaryTree.startDrawing(drawBinaryTree);
                }
            }
        } while (opcao != 7);
    }
}