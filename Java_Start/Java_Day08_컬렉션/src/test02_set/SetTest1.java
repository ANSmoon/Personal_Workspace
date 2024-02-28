package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {
    public static void main(String[] args) {
        // Set
    	// - Interface
    	
    	// 1. 집합
    	// 2. 중복 x
    	// 3. 순서 보장 x
    	
    	// HashSet : Class
    	// - HashTable : 성능 면에서 우수
    	
    	Set<String> set = new HashSet<>();
    	
    	set.add("ANSMOON");
    	set.add("PARKBOYOUNG");
    	set.add("IU");
    	set.add("LIZ");
    	set.add("IU");
    	
    	System.out.println(set);
    	System.out.println(set.size());
    	
        
        
    }
}  
