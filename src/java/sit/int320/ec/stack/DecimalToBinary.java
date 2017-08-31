/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.stack;

import java.util.LinkedList;

/**
 *
 * @author INT320
 */
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
