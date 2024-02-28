package test03_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();
        
        Person p1 = new Person("사람1", "111111");
        Person p2 = new Person("사람1", "111111");
        // hashCode, equals를 override 해줘야 한다.
        
        
        map.put(p1, 100);
        map.put(p2, 98);
        
        // 사람이 한 사람만? 아니면 두 사람?
        System.out.println(map);
    }
}
