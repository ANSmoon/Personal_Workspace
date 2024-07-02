package test07_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

     
        persons.add(new Person("BBB", 22));
        persons.add(new Person("BBB", 23));
        persons.add(new Person("AAA", 23));
        persons.add(new Person("AAA", 11));
        
        System.out.println(persons);
        
        // Person 객체가 comparable 인터페이스를 구현하고 있지 않기 때문에 
        // 사용 불가
        
        
        // 대소 비교 기준이 없으므로 정렬할 수 없음
        // 1. 해당 클래스에 Comparable 인터페이스 구현
        // 2. Comparator 만들기
        // Collections.sort(persons);
        
        Collections.sort(persons);
        
         System.out.println(persons);
    }
}
