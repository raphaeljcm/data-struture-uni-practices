package stack.practices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Question02 {
    public static void main(String[] args) throws FileNotFoundException {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        Random randomNumber = new Random();;
        Scanner scan;

        scan = new Scanner(new File("./tickets.txt"));
        while(scan.hasNextLine()) {
            queue.add(scan.nextLine());
        }

        System.out.println("----- INGRESSOS -----");
        queue.forEach(System.out::println);

        System.out.println("----- INGRESSOS VIP -----");
        for(int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }

        ArrayList<String> ingressosRestantes = new ArrayList<>(queue);
        System.out.println("\nPessoa sorteada: " + ingressosRestantes.get(randomNumber.nextInt(ingressosRestantes.size() - 1)));
    }
}
