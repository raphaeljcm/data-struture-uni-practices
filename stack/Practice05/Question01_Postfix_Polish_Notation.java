package stack.Practice05;

import java.util.Stack;

public class Question01_Postfix_Polish_Notation {
    static boolean isOperator(String el) {
        return el.equals("+") || el.equals("-") || el.equals("/") || el.equals("*");
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

                    if (operatorTemp.equals("+")) {
                        int temp = second + first;
                        myStack.push(temp);
                    } else if (operatorTemp.equals("-")) {
                        if ((first < 0) || (second < 0)) {
                            int firstV2 = Math.abs(first);
                            int secondV2 = Math.abs(second);
                            int temp = secondV2 - firstV2;

                            myStack.push(temp);
                        }
                        int temp = second - first;
                        myStack.push(temp);
                    }

                    if (operatorTemp.equals("*")) {
                        int temp = second * first;
                        myStack.push(temp);
                    }

                    if (operatorTemp.equals("/")) {
                        int temp = second / first;
                        myStack.push(temp);
                    }

                    if(myStack.size() <= 1) {
                        operatorTemp = s;
                        continue;
                    } else {
                        operatorTemp = "";
                    }
                }

                int first = myStack.pop();
                int second = myStack.pop();

                if (s.equals("+")) {
                    int temp = second + first;
                    myStack.push(temp);
                } else if (s.equals("-")) {
                    if ((first < 0) || (second < 0)) {
                        int firstV2 = Math.abs(first);
                        int secondV2 = Math.abs(second);
                        int temp = secondV2 - firstV2;

                        myStack.push(temp);
                    }
                    int temp = second - first;
                    myStack.push(temp);
                }

                if (s.equals("*")) {
                    int temp = second * first;
                    myStack.push(temp);
                }

                if (s.equals("/")) {
                    int temp = second / first;
                    myStack.push(temp);
                }
            } else {
                myStack.push(Integer.parseInt(s));
            }

            System.out.println(myStack.peek());
        }

        if(myStack.size() == 2) {
            int first = myStack.pop();
            int second = myStack.pop();

            if (operatorTemp.equals("+")) {
                int temp = second + first;
                myStack.push(temp);
            } else if (operatorTemp.equals("-")) {
                if ((first < 0) || (second < 0)) {
                    int firstV2 = Math.abs(first);
                    int secondV2 = Math.abs(second);
                    int temp = secondV2 - firstV2;

                    myStack.push(temp);
                }
                int temp = second - first;
                myStack.push(temp);
            }

            if (operatorTemp.equals("*")) {
                int temp = second * first;
                myStack.push(temp);
            }

            if (operatorTemp.equals("/")) {
                int temp = second / first;
                myStack.push(temp);
            }
        }

        return myStack.pop();
    }
}
