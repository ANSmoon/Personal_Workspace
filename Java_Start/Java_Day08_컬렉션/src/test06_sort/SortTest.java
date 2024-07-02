package test06_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();

     
        names.add("EEE");
        names.add("BBB");
        names.add("CCC");        
        names.add("AAA");
        names.add("DDD");
        
        System.out.println(names);
        
        // Collections.sort();
        Collections.sort(names);
        System.out.println(names);
        
    }
}
