package test06_multiple_implements;

public interface AbleToFly {
    void fly();
    
    // 구현부가 있는 메소드
    default void print() {
        System.out.println("날아요.");
    }
}
