package stack.practices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Question01 {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<String> stack = new Stack<>();
        ArrayList<String> top10 = new ArrayList<>();
        Scanner scan;

        scan = new Scanner(new File("./randomSentences.txt"));
        while (scan.hasNextLine()) {
            stack.push(scan.nextLine());
        }

        // FRASES
        System.out.println("---------- FRASES -------------");
        stack.forEach(System.out::println);

        for(int i = 0; i < 10; i++) {
            top10.add(stack.pop());
        }

        System.out.println();
        System.out.println("---------- OUTRAS FRASES -------------");
        stack.forEach(System.out::println);

        System.out.println();
        System.out.println("---------- TOP 10 -------------");
        top10.forEach(System.out::println);
    }
}
