package test02_inheritance;

public class ChefTest {
    public static void main(String[] args) {
    	// 다형성
    	// 부모클래스 타입으로 자식 개체 참조 가능
        Chef[] chefs = new Chef[2];
        
        chefs[0] = new KFoodChef();
        chefs[1] = new JFoodChef();
        
        for(Chef chef : chefs) {
        	chef.eat(); // 부모 클래스 타입으로 참조
        	chef.cook(); // => 자식 클래스에서 재정의한 메소드로 실행됨
        				// eat은 override 안했고, cook은 override 함.
        }

    }
}
