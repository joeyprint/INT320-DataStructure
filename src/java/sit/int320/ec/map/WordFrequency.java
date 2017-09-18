package sit.int320.ec.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordFrequency {

//    Map<String, Integer> words = new HashMap();
    Map<String, Integer> words = new TreeMap();

    public void processFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (!f.exists()) {
            System.err.println(fileName + "doesn't exist .. try again !!!");
            return;
        }
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer stkzr = new StringTokenizer(line, " ;,.:'\"[](){}");
            while (stkzr.hasMoreElements()) {
                String key = stkzr.nextToken();
                if (words.get(key) == null) {
                    words.put(key, 1);
                } else {
                    int count = words.get(key);
                    words.put(key, count + 1);
                }
            }
        }
        sc.close();
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public void showFrequency() {
        Set<Entry<String, Integer>> entrys = words.entrySet();
        for (Entry<String, Integer> e : entrys) {
            System.out.printf("%-15s%3d\n", e.getKey(), e.getValue());
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        WordFrequency wf = new WordFrequency();
        wf.processFile("data.txt");
        wf.showFrequency();
    }
}
