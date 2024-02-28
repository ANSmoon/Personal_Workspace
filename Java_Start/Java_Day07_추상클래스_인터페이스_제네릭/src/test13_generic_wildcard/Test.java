package test13_generic_wildcard;

class FlyBox<T extends AbleToFly> {
    T t;
    void setT(T t) {
        this.t = t;
    }
    
    T getT() {
        return t;
    }
}

class BirdBox<T extends Bird> {
    T t;
    void setT(T t) {
        this.t = t;
    }
    
    T getT() {
        return t;
    }
}

class FlyingAndSwimmingBirdBox<T extends Bird & AbleToFly & AbleToSwim> {
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
    
       FlyBox<?> f1; 
//       FlyBox<? extends Bird> f1; 
//       FlyBox<? super Duck> f1; 
       
       
       FlyBox<Duck> f2 = new FlyBox<>();
       FlyBox<Butterfly> f3 = new FlyBox<>();
       FlyBox<Bird> f4 = new FlyBox<>();
       
       f2.setT(new Duck());
       f3.setT(new Butterfly());
       f4.setT(new Bird());
       
       f1 = f2;
       f1.getT().fly();
       
       f1 = f3;
       f1.getT().fly();
       
       f1 = f4;
       f1.getT().fly();
        
    }
}
