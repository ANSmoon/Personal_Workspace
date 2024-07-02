package test07_multiple_extends;

public class Penguin implements AbleToSwim {

    @Override
    public void swim() {
        System.out.println("펭귄은 날 수는 없고 수영만 할 수 있습니다.");
        
    }
    
}
