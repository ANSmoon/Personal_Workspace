package test08_comparator;

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
        
        // 대소 비교 기준이 없으므로 정렬할 수 없음
        // 1. 해당 클래스에 Comparable 인터페이스 구현
        // 2. Comparator 만들기(Comparator interface 구현)
        
        
        Collections.sort(persons, new PersonComparator());
        Collections.sort(persons, new PersonComparator2());
        
        System.out.println(persons);
    }
}
