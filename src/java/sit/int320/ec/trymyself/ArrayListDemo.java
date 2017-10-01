package sit.int320.ec.trymyself;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String args[]) {
        //create array list
        ArrayList al1 = new ArrayList();
        //size of initial array list
        System.out.println("Size of initial Array List : " + al1.size());
        
        //add elements in Array List
        al1.add("Ant");
        al1.add("Bird");
        al1.add("Cat");
        al1.add("Dog");
        al1.add("Elephant");
        al1.add("Fish");
        
        //size of array list after add element
        System.out.println("Size of Array List after add element : " + al1.size());
        
        //Display value in Array list
        System.out.println("Value in array : " + al1);
        
        //Remove element in array list
        al1.remove("Ant");
        al1.remove(3);
        System.out.println("Size of Array List after remove element : " + al1.size());
        System.out.println("Value in array : " + al1);
    }
}
