package sit.int320.ec.trymyself;

import java.util.LinkedList;

public class ListedListDemo {
    public static void main(String args[]) {
        //create linked list
        LinkedList ll1 = new LinkedList();
        System.out.println("Size of initial Linked List : " + ll1.size());
        
        //add element into linked list
        ll1.add("Ant");
        ll1.add("Bird");
        ll1.add("Cat");
        ll1.add("Dog");
        ll1.add("Elephant");
        ll1.add(3, "InsertIndex3");
        ll1.addFirst("InsertFirstIndex");
        ll1.addLast("InsertLastIndex");
        
        System.out.println("Size of Linked List : " + ll1.size());
        System.out.println("Show element : " + ll1);
        //search element
        System.out.println("Search element index 5 : " + ll1.get(5));
        
        //remove element first and last
        ll1.removeFirst(); //ll1.remove();
        ll1.removeLast();
        System.out.println("Show element after remove first and last : " + ll1);
        
        //remove element
        ll1.remove(3);
        ll1.remove("Ant");
        System.out.println("Show element after remove : " + ll1);
        
        //change value in linked list
        ll1.set(1, "Changed");
        System.out.println("Show element after change value index 1 : " + ll1);
    }
}
