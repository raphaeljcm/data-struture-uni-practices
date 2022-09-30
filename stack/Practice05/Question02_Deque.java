package stack.Practice05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Question02_Deque {

    private final String name;
    private final String phone;
    private final String email;

    public Question02_Deque(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return getName() + " " + getPhone() + " " + getEmail();
    }

    public static void main(String[] args) {
        Deque<Question02_Deque> dq = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            System.out.println("Informe o nome");
            String name = scanner.nextLine();
            System.out.println("Informe o telefone");
            String phone = scanner.nextLine();
            System.out.println("Informe o email");
            String email = scanner.nextLine();

            var result = new Question02_Deque(name, phone, email);
            dq.add(result);
        }

        System.out.println("Ordem convencional");
        for (Iterator itr = dq.iterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + " ");
        }

        System.out.println();

        System.out.println("Ordem inversa");
        for (Iterator itr = dq.descendingIterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + " ");
        }

        scanner.close();
    }
}
