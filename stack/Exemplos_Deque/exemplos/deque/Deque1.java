package stack.Exemplos_Deque.exemplos.deque;

//Fonte: https://acervolima.com/interface-deque-em-java-com-exemplo/

import java.util.Deque;
import java.util.LinkedList;

public class Deque1 {

	public static void main(String[] args) {
		 Deque<String> deque = new LinkedList<String>();

     // Podemos adicionar elementos tanto na cabe�a quanto na cauda

     //adicionar elemento padr�o
     deque.add("Element 1 (Tail)");

     // adicionar no inicio
     deque.addFirst("Element 2 (Head)");

     // adiciona no final
     deque.addLast("Element 3 (Tail)");

     // Adicionar na primeira posi��o cabe�a
     deque.push("Element 4 (Head)");

     // Adiciona na ultima posi��o cauda
     deque.offer("Element 5 (Tail)");

     // Adiciona antes do primeiro
     deque.offerFirst("Element 6 (Head)");

     System.out.println(deque + "\n");

    // Teste de remover o primeiro
    // e o ultimo elemento
     deque.removeFirst();
     deque.removeLast();
     System.out.println("Impress�o depois da remo��o do primeiro e do �ltimo " + deque);
	}

}
