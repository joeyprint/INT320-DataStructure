package sit.int320.ec.stack;

import java.util.LinkedList;

public class DecimalToBinary {

    public static void main(String args[]) {
        int x = 125;
        String y = Integer.toBinaryString(x);
        System.out.println(y);
        y = dec2Bin(x);
        System.out.println(y);
    }

    public static String dec2Bin(int x) {
        LinkedList<String> stack = new LinkedList();
        StringBuilder result = new StringBuilder();
        stack.push(x % 2 + "");
        while (x>1) {
            x = x/2;
            stack.push(x%2 + "");
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
