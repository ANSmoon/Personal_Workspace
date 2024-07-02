package test08_comparator;

import java.util.Comparator;

public class PersonComparator2 implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        // 1. 나이순
        // 2. 이름순
        if(o1.age == o2.age) {
            return o1.name.compareTo(o2.name); 
        }
        return o1.age - o2.age; 
    }

}
