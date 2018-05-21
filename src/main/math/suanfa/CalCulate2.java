package main.math.suanfa;

import java.util.Stack;

public class CalCulate2 {
    public static void main(String[] args) {
        System.out.println(calculate("5/3"));
    }

    public static int calculate(String s) {
        s = s + "+";
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                if (Character.isDigit(s.charAt(i))) {
                    int n = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        n = n * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    numStack.push(n);
                }
                while (i < s.length() && !numStack.isEmpty() && !Character.isDigit(s.charAt(i))) {
                    if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                        if (numStack.size() > 1) {
                            while (!operatorStack.isEmpty()) {
                                int a = numStack.pop();
                                int b = numStack.pop();
                                Character operator = operatorStack.pop();
                                if (operator == '-') {
                                    numStack.push(a - b);
                                } else if (operator == '+') {
                                    numStack.push(a + b);
                                }
                            }
                        }
                        operatorStack.push(s.charAt(i));
                        i++;
                    } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                        Character operator = s.charAt(i);
                        i++;
                        int next = 0;
                        while (i < s.length() && Character.isDigit(s.charAt(i))) {
                            next = next * 10 + (s.charAt(i) - '0');
                            i++;
                        }
                        int previous = numStack.pop();
                        if (operator == '*') {
                            numStack.push(previous * next);
                        } else {
                            numStack.push(previous / next);
                        }
                    }
                }
            } else {
                i++;
            }

            // 3/2 TODO Time Limit Exceeded
        }
        return numStack.peek();
    }
}
