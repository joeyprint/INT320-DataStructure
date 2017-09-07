/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.map;

/**
 *
 * @author INT320
 */
public class TestHashTable {

    public static void main(String args[]) {
        System.out.println("Somchai".hashCode());
        System.out.println("abc".hashCode());
        System.out.println("This".hashCode());
        Integer x = new Integer(900);
        System.out.println(x.hashCode());
    }
}
