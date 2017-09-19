package sit.int320.ec.tuewithsun;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class StackTue {

    public static void main(String args[]) {
        System.out.println(totalValue(infixToPostfix("3 * 5 + 3 / 7")));
    }
    
    public static double totalValue(String postfix) {
        String result = null;
        LinkedList<String> stackOperand = new LinkedList<String>();
        StringTokenizer stk = new StringTokenizer(postfix, " ");
        while (stk.hasMoreTokens()) {
            String token = stk.nextToken();
            if (!checkOperater(token)) {
                stackOperand.push(token);
            } else {
                double right = Double.parseDouble(stackOperand.pop());
                double left = Double.parseDouble(stackOperand.pop());
                
                if (token.equals("+")){
                    result = (left + right) + "";
                } else if (token.equals("-")) {
                    result = (left - right) + "";
                } else if (token.equals("*")) {
                    result = (left * right) + "";
                } else if (token.equals("/")) {
                    result = (left / right) + "";
                } else if (token.equals("%")) {
                    result = (left % right) + "";
                }
                
                stackOperand.push(result);
            }
        }
        return Double.parseDouble(stackOperand.peek());
    }
    
    public static String infixToPostfix(String number) {
        LinkedList<String> stackOperater = new LinkedList<String>(); // add operater to stack
        StringBuilder postfix = new StringBuilder(); // add operand
        StringTokenizer stk = new StringTokenizer(number, " "); // substring with space
        while (stk.hasMoreTokens()) {
            String token = stk.nextToken();
            if (!checkOperater(token)) {
                postfix.append(token);
                postfix.append(" ");
            } else {
                if(stackOperater.isEmpty()){
                    stackOperater.push(token);
                } else {
                    // peek : seen top operater
                    while (!stackOperater.isEmpty() && valueOfOperater(token) <= valueOfOperater(stackOperater.peek())) {
                        postfix.append(stackOperater.pop());
                        postfix.append(" ");
                    }
                    stackOperater.push(token);
                }
                
            }
        }
        
        while (!stackOperater.isEmpty()) {
            postfix.append(stackOperater.pop());
            postfix.append(" ");
        }
        
        return postfix.toString();
    }

    public static boolean checkOperater(String token) {
        switch (token) {
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

    public static int valueOfOperater(String token) {
        if (checkOperater(token)) {
            switch (token) {
                case "+":
                case "-":
                    return 1;
                case "*":
                case "/":
                case "%":
                    return 3;
            }
        }
        throw new ArithmeticException("You Enter Operand it's wrong !!");
    }
}
