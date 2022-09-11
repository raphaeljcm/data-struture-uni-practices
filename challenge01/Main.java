package challenge01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DoublyLinkedList listaNoiva = new DoublyLinkedList();
        DoublyLinkedList listaNoivo = new DoublyLinkedList();
        DoublyLinkedList listaJoin = new DoublyLinkedList();
        Scanner scan;

        // Lista Noivo
        scan = new Scanner(new File("./listaNoivo.txt"));
        while(scan.hasNextLine()) {
            listaNoivo.insertLast(scan.nextLine());
        }

        // Lista Noiva
        scan = new Scanner(new File("./listaNoiva.txt"));
        while(scan.hasNextLine()) {
            listaNoiva.insertLast(scan.nextLine());
        }
        scan.close();

        // União
        for(int i = 0; i < listaNoiva.length(); i++) {
            listaJoin.insertLast(listaNoiva.getCurrent(i));

            if(i < listaNoivo.length()) {
                listaJoin.insertLast(listaNoivo.getCurrent(i));
            }
        }

        // Ordena a lista
        listaJoin.sortList();

        // Mostrar
        System.out.println("----------- LISTA DE CONVIDADOS -------------");

        System.out.println("\nLISTA NOIVO");
        for(int i = 0; i < listaNoivo.length(); i++) {
            System.out.println(listaNoivo.getCurrent(i));
        }

        System.out.println("\nLISTA NOIVA");
        for(int i = 0; i < listaNoiva.length(); i++) {
            System.out.println(listaNoiva.getCurrent(i));
        }

        System.out.println("\nLISTA ORDENADA");
        for(int i = 0; i < listaJoin.length(); i++) {
            System.out.println(listaJoin.getCurrent(i));
        }

        System.out.println("\n LISTA COMPLETA");
        for(int i = 0; i < listaJoin.length(); i++) {
            System.out.println("ATUAL");
            System.out.println(listaJoin.getCurrent(i));

            if(listaJoin.getCurrent(i) == listaJoin.getTail()) {
                System.out.println("ACABOU!");
                break;
            }

            System.out.println("PROXIMO");
            System.out.println(listaJoin.getNext(i));
        }
    }
}
