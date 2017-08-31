/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.stack;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author INT320
 */
public class InfixToPosfix {

    public static void main(String args[]) {
        String posfix = infixToPosfix("15 + 2 * 4 - 3 / 7");
        double x = evaluate(posfix);
        System.out.println(x);
    }

    public static double evaluate(String posfix) {
        StringTokenizer stk = new StringTokenizer(posfix); //default check space token
        LinkedList<Double> stack = new LinkedList();
        while (stk.hasMoreElements()) {
            String x = stk.nextToken();
            if (isOperator(x)) {
                double second = stack.pop();
                double first = stack.pop();
                double result = evaluate(first, x, second);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(x));
            }
        }
        return stack.peek();
    }

    private static double evaluate(double first, String x, double second) {
        switch (x) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "%":
                return first % second;
            default:
                throw new RuntimeException(x + " does not oparator !!!");
        }
    }

    public static String infixToPosfix(String infix) {
        StringBuilder posfix = new StringBuilder(); //posfix is storage value
        LinkedList<String> stack = new LinkedList();
        StringTokenizer stk = new StringTokenizer(infix); //default check space token
        while (stk.hasMoreElements()) {
            String x = stk.nextToken();
            if (isOperator(x)) {
                while (!stack.isEmpty() && precedence(x) <= precedence(stack.peek())) {
                    String tmp = stack.pop();
                    posfix.append(tmp);
                    posfix.append(" ");
                }
                stack.push(x);

            } else {
                posfix.append(x);
                posfix.append(" ");
            }
        }
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            posfix.append(tmp);
            posfix.append(" ");
        }
        posfix.deleteCharAt(posfix.length() - 1);
        return posfix.toString();
    }

    private static boolean isOperator(String x) {
        switch (x) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return true;
            default:
                return false;
        }
    }

    private static int precedence(String x) {
        switch (x) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 3;
            default:
                throw new RuntimeException(x + " dose not operator !!!");
        }
    }
}
