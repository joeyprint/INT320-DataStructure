package sit.int320.ec.trymyself;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableDemo {

    public static void main(String srgs[]) {
        //Create Hash Map
        Hashtable balance = new Hashtable();
        Enumeration name;
        String str;
        double bal;

        balance.put("Joey", 4500.00);
        balance.put("Ming", 5250.50);
        balance.put("Bas", 3520.75);
        balance.put("Big", 2500.00);
        balance.put("Son", 5100.79);

        //Show balance in hash table
        name = balance.keys();
        while (name.hasMoreElements()) {
            str = (String) name.nextElement();
            System.out.println(str + " : " + balance.get(str));
        }

        //If deposit account
        bal = ((Double)balance.get("Joey")).doubleValue();
        balance.put("Joey", bal + 1000);
        System.out.println("New balance of Joey : " + balance.get("Joey"));
    }
    }
