package stack.Exemplos_Pilha_Fila.fila.exemplos.simples;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.Iterator;

public class Exemplo2Fila {

	public static void main(String[] args) {
		 Queue<String> pq = new PriorityQueue<>();
		  
	        pq.add("Ana");
	        pq.add("Jo�o");
	        pq.add("Marcos");
	        pq.add("Camila");
	        pq.add("Joana");
	  
	        System.out.println(pq);
	        
	        pq.remove("Marcos");
	        
	        System.out.println("Ap�s a Remo��o de Ana: " + pq);
	  
	        System.out.println("M�todo poll (remove o cabe�alho da fila e retorna): " + pq.poll());
	  
	        System.out.println("Fila Final:  " + pq);
	        //outro m�todo de interar a fila
	       
	        
	        System.out.println("***M�todo de Interar a Fila***");
	        Iterator iterator = pq.iterator();
	        
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + "\n");
	        }
	}

}
