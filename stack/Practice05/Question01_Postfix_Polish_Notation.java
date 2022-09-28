package stack.Practice05;

import java.util.EmptyStackException;
import java.util.Stack;

public class Question01_Postfix_Polish_Notation {
    static boolean isOperator(String el) {
        if (el.equals("+") || el.equals("-") || el.equals("/") || el.equals("*")) {
            return true;
        }

        return false;
    }

    public static int generatePostfixPolishNotation(String expression[]) {
        int expressionLength = expression.length;

        Stack<Integer> myStack = new Stack<>();

        for(int i = 0; i < expressionLength; i++) {
            if(isOperator(expression[i])) {
                int first = myStack.pop();
                int second = myStack.pop();

                if(expression[i].equals("+")) {
                    int temp = first + second;
                    myStack.push(temp);
                } else if(expression[i].equals("-")) {
                    if((first < 0) || (second < 0)) {
                        int firstV2 = Math.abs(first);
                        int secondV2 = Math.abs(second);
                        int temp = firstV2 - secondV2;

                        myStack.push(temp);
                    }
                    int temp = first - second;
                    myStack.push(temp);
                }

                if(expression[i].equals("*")) {
                    int temp = first * second;
                    myStack.push(temp);
                }

                if(expression[i].equals("/")) {
                    int temp = first / second;
                    myStack.push(temp);
                }
            } else {
                myStack.push(Integer.parseInt(expression[i]));
            }

            System.out.println(myStack.peek());
        }

        return myStack.pop();
    }
}
