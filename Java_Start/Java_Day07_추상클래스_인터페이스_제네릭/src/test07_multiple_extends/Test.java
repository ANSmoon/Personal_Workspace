package test07_multiple_extends;

public class Test {
    public static void main(String[] args) {
        Duck d = new Duck();
        Butterfly b = new Butterfly();
        Penguin p = new Penguin();
        Swan sw = new Swan();
        
        b.fly();
         // default 메소드
        
        AbleToSwim.info();
        
        AbleToFly[] flying = new AbleToFly[4];
        flying[0] = d;
        flying[1] = b;
        //flying[2] = p;
        flying[3] = sw;
        
        for(AbleToFly f : flying) {
            if(f!= null)
                f.fly();
        }
        
        AbleToSwim[] swimming = new AbleToSwim[4];
        swimming[0] = d;
        // swimming[1] = b;
        swimming[2] = p;
        swimming[3] = sw;
        
        for(AbleToSwim s : swimming) {
            if(s != null)
                s.swim();
        }
    }
}
