package test08_comparator;

import java.util.Comparator;

// Comparator를 만들기 위해서는 Comparator interface를 구현
public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}

}
