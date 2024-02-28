package test08_comparator;


// Comparable interface를 구현하고 있지 않아서
// 기본적으로 sort 불가능
// comparator가 있다면, Comparable을 구현하지 않더라도 Comparator를 사용해서 정렬 가능
public class Person {
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

    
}
