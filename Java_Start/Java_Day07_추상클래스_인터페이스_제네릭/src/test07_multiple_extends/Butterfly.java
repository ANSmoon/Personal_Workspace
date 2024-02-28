package test07_multiple_extends;

public class Butterfly implements AbleToFly {

    @Override
    public void fly() {
        System.out.println("나비는 날 수 있어요.");
        
    }
    
    // default 메소드는 구현할 필요 없다.
}
