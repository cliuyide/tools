package main.math.suanfa;

import java.util.Stack;

public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculate(" 2-1 + 2 "));
    }

    public static int calculate(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i=0;
        while (i < s.length() && s.charAt(i) != ' ') {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                operatorStack.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == ')') {
                while (!operatorStack.isEmpty()&&operatorStack.peek() != '(') {
                    int n = numberStack.pop();
                    int m = numberStack.pop();
                    if (operatorStack.peek() == '-') {
                        numberStack.push(m - n);
                    } else {
                        numberStack.push(m + n);
                    }
                    operatorStack.pop();
                }
                // "("出栈
                operatorStack.pop();

                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    int n = numberStack.pop();
                    int m = numberStack.pop();
                    if (operatorStack.peek() == '-') {
                        numberStack.push(m - n);
                    } else {
                        numberStack.push(m + n);
                    }
                    operatorStack.pop();
                }
                i++;
            } else {
                int num=0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numberStack.push(num);
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    int n = numberStack.pop();
                    int m = numberStack.pop();
                    if (operatorStack.peek() == '-') {
                        numberStack.push(m - n);
                    } else {
                        numberStack.push(m + n);
                    }
                    operatorStack.pop();
                }

            }
        }
        return numberStack.peek();
    }
}
