package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        // Set에서 중복 판단 방법
        // 1. HashCode(); 일치시키기
        // 2. equals() 오버라이드
        
        
        Person p1 = new Person("JUNGEUNJI", "111111");
        Person p2 = new Person("JUNGEUNJI", "111111");
        
        set.add(p1);
        set.add(p2);
        
        // 사람이 한 사람만? 아니면 두 사람?
        System.out.println(set);
        
        // Object로부터 물려받은 계산 logic을 쓰는 게 아니라
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        
        // String에서 override한 계산 logic을 쓴다.
        System.out.println("JUNGEUNJI".hashCode());
        System.out.println("JUNGEUNJI".hashCode());
    }
}
