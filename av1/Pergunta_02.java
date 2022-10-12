package av1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Pergunta_02 {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<String> stack01 = new Stack<>();
        Stack<String> stack02 = new Stack<>();
        Stack<String> stack03 = new Stack<>();
        Scanner scan;

        scan = new Scanner(new File("./pilha1.txt"));
        while (scan.hasNextLine()) {
            stack01.push(scan.nextLine());
        }

        scan = new Scanner(new File("./pilha2.txt"));
        while (scan.hasNextLine()) {
            stack02.push(scan.nextLine());
        }

        scan = new Scanner(new File("./pilha3.txt"));
        while (scan.hasNextLine()) {
            stack03.push(scan.nextLine());
        }

        while(!stack03.empty()) {
            System.out.println("Assistente 1 - prato: " + stack01.pop());
            System.out.println("Assistente 2 - prato: " + stack02.pop());
            System.out.println("Assistente 3 - prato: " + stack03.pop());
        }
    }
}
