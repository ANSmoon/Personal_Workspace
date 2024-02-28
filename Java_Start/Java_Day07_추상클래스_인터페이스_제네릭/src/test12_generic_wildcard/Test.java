package test12_generic_wildcard;

class Box<T> {
    T t;
    void setT(T t) {
        this.t = t;
    }
    
    T getT() {
        return t;
    }
}



public class Test {
    public static void main(String[] args){
    
       Box<?> b1; 
//       Box<? extends Bird> b1;
//       Box<? super Duck> b1;
       

       
       
       Box<Duck> b2 = new Box<>(); // Duck의 Box
       b2.setT(new Duck());
       
       Box<Butterfly> b3 = new Box<>(); // Butterfly
       b3.setT(new Butterfly());
       
       Box<Bird> b4 = new Box<>(); // Bird
       b4.setT(new Bird());
       
       Box<String> b5 = new Box<>(); // String
       b5.setT("Hahaha");
       
       Box<Bird> b13 = new Box<Bird>();
       
       // 우리가 구체적인 해당 타입을 모른다고 가정할 때
       Box<?> b10 = new Box<Bird>();
       Box<?> b11 = new Box<String>();
       Box<?> b12 = new Box<Integer>();
       
       b1 = b2;
       System.out.println(b1.getT().toString());       
       
       b1 = b3;
       System.out.println(b1.getT().toString());
       
       b1 = b4;
       System.out.println(b1.getT().toString());
       
       b1 = b5;
       System.out.println(b5.getT().toString());
        
    }
}
