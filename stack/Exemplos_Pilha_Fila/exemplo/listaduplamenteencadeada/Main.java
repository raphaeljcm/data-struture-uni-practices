package stack.Exemplos_Pilha_Fila.exemplo.listaduplamenteencadeada;

public class Main {

	public static void main(String[] args) {
		 ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

	        minhaListaEncadeada.addA("Jo�o");
	        minhaListaEncadeada.addA("Maria");
	        minhaListaEncadeada.addA("Pedro");
	        minhaListaEncadeada.addA("Carlos");
	        minhaListaEncadeada.addA("Magno");
	        minhaListaEncadeada.addA("Michelle");
	        minhaListaEncadeada.addA("Marcos");
	        
	        System.out.println("****Lista duplamente encadeada***");
	        System.out.println(minhaListaEncadeada);
	        System.out.println("Retorna o elemento na posi��o 3");
	        System.out.println(minhaListaEncadeada.get(3));
	        
	        System.out.println("Remove o elemento da posi��o 3");
	        minhaListaEncadeada.remove(3);
	        
	        System.out.println("Adiciona o elemento Teste na terceira posi��o");
	        minhaListaEncadeada.addB(3, "Teste");
	        
	        System.out.println("****Lista duplamente encadeada Ap�s Altera��o***");
	        System.out.println(minhaListaEncadeada);
	    }
}
