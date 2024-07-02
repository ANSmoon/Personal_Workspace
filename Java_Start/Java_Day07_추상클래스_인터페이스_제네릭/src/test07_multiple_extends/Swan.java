package test07_multiple_extends;

public class Swan implements Duckable {

    @Override
    public void swim() {
        System.out.println("백조는 오리처럼 수영도 할수 있어요.");
        
    }

    @Override
    public void fly() {
        System.out.println("백조는 오리처럼 날수도 있어요.");
        
    }

}
