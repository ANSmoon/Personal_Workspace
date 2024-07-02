package test05_object_serialization;

// Serializable 인터페이스를 구현하면 되는데
// 부모 구현 -> 자식도 구현된 것으로 봄
// 자식만 구현 -> 부모는 직렬화 불가.
public class Person {

	String name;

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
