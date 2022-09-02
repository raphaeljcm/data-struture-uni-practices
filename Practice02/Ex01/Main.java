package Practice02.Ex01;

import Practice02.Ex01.ListaLigada;

public class Main {
    public static void main(String[] args) {
        ListaLigada filaBanco = new ListaLigada();

        // Prioritários
        for(int i = 1; i <= 100; i++) {
            if(i % 2 != 0) {
                filaBanco.inserirFinal(i);
            }
        }

        // Comum
        for(int i = 1;  i <= 200; i++) {
            if(i > 100 || i % 2 == 0) {
                filaBanco.inserirFinal(i);
            }
        }

        filaBanco.mostrarLista();
    }
}
