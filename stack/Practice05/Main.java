package stack.Practice05;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws EmptyStackException  {
        String expression = "4 3 * 2 + 5 - 1";
        String expressionArray[] = expression.split(" ");

        System.out.println("Expression: " + expression);
        int result = Question01_Postfix_Polish_Notation.generatePostfixPolishNotation(expressionArray);
        System.out.println("Result: " + result);
    }
}
