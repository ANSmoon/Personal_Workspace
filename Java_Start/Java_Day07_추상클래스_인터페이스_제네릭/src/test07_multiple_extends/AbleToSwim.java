package test07_multiple_extends;

public interface AbleToSwim {
    void swim();
    
    default void print() {
    	System.out.println("수영해요");
    }
    
    public static void info() {
    	System.out.println("Hello");
    }
}
