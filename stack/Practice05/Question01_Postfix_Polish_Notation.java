package stack.Practice05;

import java.util.Stack;

public class Question01_Postfix_Polish_Notation {
    static boolean isOperator(String el) {
        return el.equals("+") || el.equals("-") || el.equals("/") || el.equals("*");
    }

    static int doOperation(int first, int second, String operator) {
        if (operator.equals("+")) {
            int temp = second + first;
            return temp;
        } else if (operator.equals("-")) {
            if ((first < 0) || (second < 0)) {
                int firstV2 = Math.abs(first);
                int secondV2 = Math.abs(second);
                int temp = secondV2 - firstV2;

                return temp;
            }
            int temp = second - first;
            return temp;
        }

        if (operator.equals("*")) {
            int temp = second * first;
            return temp;
        }

        if (operator.equals("/")) {
            int temp = second / first;
            return temp;
        }

        return 0;
    }

    public static int generatePostfixPolishNotation(String[] expression) {
        Stack<Integer> myStack = new Stack<>();
        String operatorTemp = "";

        for (String s : expression) {
            if (isOperator(s)) {
                if(myStack.size() <= 1) {
                    operatorTemp = s;
                    continue;
                }

                if(!operatorTemp.isEmpty()) {
                    int first = myStack.pop();
                    int second = myStack.pop();

                    int result = doOperation(first, second, operatorTemp);
                    myStack.push(result);

                    if(myStack.size() <= 1) {
                        operatorTemp = s;
                        continue;
                    } else {
                        operatorTemp = "";
                    }
                }

                int first = myStack.pop();
                int second = myStack.pop();

                int result = doOperation(first, second, s);
                myStack.push(result);
            } else {
                myStack.push(Integer.parseInt(s));
            }

            System.out.println(myStack.peek());
        }

        if(myStack.size() == 2) {
            int first = myStack.pop();
            int second = myStack.pop();

            int result = doOperation(first, second, operatorTemp);
            myStack.push(result);
        }

        return myStack.pop();
    }
}
