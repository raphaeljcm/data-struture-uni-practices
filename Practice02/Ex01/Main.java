package Practice02.Ex01;

import Practice02.Ex01.ListaLigada;

public class Main {
    public static void main(String[] args) {
        ListaLigada filaPrioridade = new ListaLigada();
        ListaLigada filaComum = new ListaLigada();

        for(int i = 1; i <= 200; i++) {
            if ((1 % 2 != 0) && (i <= 100)) {
                filaPrioridade.inserirFinal(i);
            } else {
                filaComum.inserirFinal(i);
            }
        }

        System.out.println("----------------- Fila Prioridade ---------------- \n");
        filaPrioridade.mostrarLista();

        System.out.println("\n----------------- Fila Comum ---------------- \n");
        filaComum.mostrarLista();
    }
}