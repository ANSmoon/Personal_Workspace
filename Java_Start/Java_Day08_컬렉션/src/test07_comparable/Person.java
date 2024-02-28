package test07_comparable;

// 컬렉션 framework에서 정렬 가능하도록 하려면
// Comparable interface를 구현해야 한다.
public class Person implements Comparable<Person>{
    String name;
    int age;
    
    
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    // 양수 => switch
    // 음수 => 그대로
    // 0 => 그대로
    
//	@Override
//	public int compareTo(Person o) {
//		// this (자기자신객체) & o 객체를 비교해 => 정수값 반환
//		
//		// 나이순으로 정렬 한다면?
//		// 기본적으로 오름차순으로 정렬한다면
//		// 3, 8, 11, 22
//		// 앞의 숫자가 작고, 뒤에 숫자가 크다.
//		// 앞 - 뒤 = 음수
//		
//		// 만약 나이가 같다면 이름 순서로 재정렬
//		// 이름은 String => string의 comparto 사용 => default = 오름차순
//		if(this.age == o.age) {
//			return this.name.compareTo(o.name);
//		}
//		
//		return this.age - o.age;
//	}

    public int compareTo(Person o) {
    	// 1. name
    	// 2. age
    	if(this.name.equals(o.name)) {
    		return this.age - o.age;
    	}
    	
    	return this.name.compareTo(o.name);
    }
    
}
