package main.math.suanfa;

import java.util.Stack;

public class CalCulate2 {
    public int calculate(String s) {
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
                    while (!operatorStack.isEmpty() && !numStack.isEmpty()) {
                        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                            operatorStack.push(s.charAt(i));
                        } else {
                            // operatorStack
                        }
                    }
                }
            } else {
                i++;
            }
        }
        return 0;
    }
}
