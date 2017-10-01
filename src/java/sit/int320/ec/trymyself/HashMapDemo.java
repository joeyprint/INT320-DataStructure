package sit.int320.ec.trymyself;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String args[]) {
        //create hashmap
        HashMap hm = new HashMap();
        
        //put element into HashMap
        hm.put("Joey", 4500.00);
        hm.put("Ming", 5250.50);
        hm.put("Bas", 3546.75);
        hm.put("Big", 8465.53);
        hm.put("Son", -23.02);
        
        System.out.println("Show element in HashMap (Key=Value): " + hm);
        
        //Get a set of entries
        Set set = hm.entrySet(); //mapping contained in this map
        
        //Get an Iterator
        Iterator i = set.iterator(); //return no particular order
        
        //Display element
        System.out.println("\nShow element in HashMap");
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
        
        //If deposit account
        double balance = ((Double)hm.get("Joey")).doubleValue();
        hm.put("Joey", balance + 1000);
        System.out.println("\nnew balance of Joey : " + hm.get("Joey"));
    }
}
