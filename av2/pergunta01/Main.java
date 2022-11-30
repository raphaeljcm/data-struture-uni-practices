package av2.pergunta01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, FullStackException {
        ArrayStack<String> stack = new ArrayStack<>();
        LinkedList<String> list = new LinkedList<>();
        Scanner scan;

        scan = new Scanner(new File("./nomes.txt"));
        while (scan.hasNextLine()) {
            stack.push(scan.nextLine());
        }

        while (!stack.isEmpty()) {
            var name = stack.pop();
            list.push(name);
        }

        System.out.println("---------- Nomes -------------");
        list.forEach(System.out::println);
    }
}
