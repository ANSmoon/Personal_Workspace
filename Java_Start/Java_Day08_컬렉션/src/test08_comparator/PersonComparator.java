package test08_comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        // 1. 이름순
        // 2. 나이순
        if (o1.name.equals(o2.name))
            return o1.age - o2.age; 
        
        return o1.name.compareTo(o2.name);
    }

}
