package test10_generic_restriction;


class Box<T extends Number> { 
    private T t;
    
    public T getT() { // Number만 반환 가능
        return t;
    }
    
    public void setT(T t) {
        this.t = t;
    }
}

public class BoxTest {
    public static void main(String[] args) {

        
        Box<Integer> intBox = new Box<>();
        intBox.setT(111);
        
//        Box<String> strBox = new Box<>();
//        strBox.setT("Hello");
        
        Box<Double> dblBox = new Box<>();
        dblBox.setT(42.21);
        
        
    }
}
