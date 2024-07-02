package test09_generic_box;

// generic class : type을 매개변수화 했다.
// <>type parameter

class Box<T>{ // T : String, Double, Integer ...
    private T t;
    
    public T getT() {
        return t;
    }
    
    public void setT(T t) {
        this.t = t;
    }
}

public class BoxTest {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<Integer>(); // integer만 들어갈 수 있는 BOX
        intBox.setT(11); // type 체크를 해준다.
        
        int num = intBox.getT();
        System.out.println(num);
        
        Box<String> str = new Box<String>();
        str.setT("String");
        
        
        String sentence = str.getT();
        System.out.println(sentence);
        
        Box<String>[] strBox = new Box[10];
        
    }
}
