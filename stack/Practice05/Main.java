package stack.Practice05;

public class Main {
    public static void main(String[] args)  {
        String expression = "2 * 1 + 3";
        String[] expressionArray = expression.split(" ");

        System.out.println("Expression: " + expression);
        int result = Question01_Postfix_Polish_Notation.generatePostfixPolishNotation(expressionArray);
        System.out.println("Result: " + result);
    }
}
