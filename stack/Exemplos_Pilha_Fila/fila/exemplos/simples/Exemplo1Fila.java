package stack.Exemplos_Pilha_Fila.fila.exemplos.simples;
/*Como Fila � uma interface, n�o podem ser criados objetos do tipo fila. Sempre precisamos de uma classe que estenda essa lista para criar um objeto.
 E tamb�m, ap�s a introdu��o dos Gen�ricos no Java 1.5, � poss�vel restringir o tipo de objeto que pode ser armazenado na Fila. Essa fila de seguran�a de tipo pode ser definida como:
 Obj � o tipo do objeto a ser armazenado na Queue 
Queue <Obj> queue = new PriorityQueue <Obj>(); */
//Refer�ncias: https://acervolima.com/interface-de-fila-em-java/

import java.util.LinkedList;
import java.util.Queue;

public class Exemplo1Fila {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

    // Adicionar os elements {0, 1, 2, 3, 4} na fila
    for (int i = 0; i < 5; i++)
        q.add(i);

    // Exibe os elementos da Fila
    System.out.println("Elementos da Fila " + q);

    // Remove o primeiro elemento da fila
    int removedele = q.remove();
    System.out.println("removed element-" + removedele);

    System.out.println(q);

    // Retorna a "cabe�a da fila
    int head = q.peek();
    System.out.println("Cabe�a da Fila: " + head);

    //Mostra o tamanho da Fila
    int size = q.size();
    System.out.println("Tamanho da Fila: " + size);
	}

}
