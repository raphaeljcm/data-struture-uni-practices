package Practice02.Ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ListaLigada listaNoiva = new ListaLigada();
        ListaLigada listaNoivo = new ListaLigada();
        ListaLigada listaJoin = new ListaLigada();
        Scanner scan;

        // Lista Noivo
        scan = new Scanner(new File("./listaNoivo"));
        while(scan.hasNextLine()) {
            listaNoivo.adicionar(scan.nextLine());
        }

        // Lista Noiva
        scan = new Scanner(new File("./listaNoiva"));
        while(scan.hasNextLine()) {
            listaNoiva.adicionar(scan.nextLine());
        }
        scan.close();

        // União
        for(int i = 0; i < listaNoiva.getTamanho(); i++) {
            listaJoin.adicionar(listaNoiva.get(i).getValor());

            if(i < listaNoivo.getTamanho()) {
                listaJoin.adicionar(listaNoivo.get(i).getValor());
            }
        }

        // Ordena a lista
        BubbleSort listaOrdenada = new BubbleSort();
        listaJoin = listaOrdenada.sortList(listaJoin);

        // Mostrar
        System.out.println("----------- LISTA DE CONVIDADOS -------------");

        System.out.println("\nLISTA NOIVO");
        for(int i = 0; i < listaNoivo.getTamanho(); i++) {
            System.out.println(listaNoivo.get(i).getValor());
        }

        System.out.println("\nLISTA NOIVA");
        for(int i = 0; i < listaNoiva.getTamanho(); i++) {
            System.out.println(listaNoiva.get(i).getValor());
        }

        System.out.println("\nLISTA ORDENADA");
        for(int i = 0; i < listaJoin.getTamanho(); i++) {
            System.out.println(listaJoin.get(i).getValor());
        }
    }
}