package test07_multiple_extends;

public class Duck implements Duckable {

    @Override
    public void swim() {
        System.out.println("오리는 수영을 합니다.");
        
    }

    @Override
    public void fly() {
        System.out.println("오리는 날 수도 있어요.");
        
    }

}
