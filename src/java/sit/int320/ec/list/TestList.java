package sit.int320.ec.list;

import java.util.List;
import java.util.Random;

public class TestList {

    public static void main(String args[]) {
//        List<Integer> list = new SimpleArrayList();
        List<Integer> list = new DoubleLinkedList();
        
        Random r = new Random();
//        list.add(100);
        for (int i = 0; i < 5; i++) {
            list.add(r.nextInt(1000));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%3d%s", list.get(i), ((i + 1) % 10 == 0 ? "\n" : "\t"));

        }
//        System.out.println(list.size());
    }

}
