package test04_abstract_method;

// 만약 추상클래스를 상속받은 자식 클래스라면,
// 1. 해당 추상메소드를 반드시 override 하거나 => 자기 자신의 완전한 클래스가 되는 것
// 2. override하지 않고, 자기 자신도 추상 클래스가 된다. => 단, 추상화 클래스는 객체 생성 불가능



public class JFoodChef extends Chef {
    
    // @Override
    public void cook() {
        System.out.println("일식을 조리한다.");
    }
}
