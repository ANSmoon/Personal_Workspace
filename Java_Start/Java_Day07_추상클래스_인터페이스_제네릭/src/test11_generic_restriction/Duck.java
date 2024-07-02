package test11_generic_restriction;

public class Duck extends Bird implements Duckable, AbleToFly {

    @Override
    public void swim() {
        System.out.println("오리는 수영을 합니다.");
        
    }

    @Override
    public void fly() {
        System.out.println("오리는 날 수도 있어요.");
        
    }

}
