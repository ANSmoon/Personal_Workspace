package test04_abstract_method;

public class ChefTest {
    public static void main(String[] args) {
        Chef[] chefs = new Chef[2];
        
        chefs[0] = new KFoodChef();
        chefs[1] = new JFoodChef();
        
        // Chef 설계도에서, 쓰이지 않는 cook() 메서드를 삭제했더니
        // 자식 객체가 cook() 메서드를 갖고 있다하더라도 접근 불가.
        // 그렇기 때문에 상속관계에 있는 상위 메소드를 삭제한다면 하위 자식에서
        // 메소드를 재정의 하더라도 사용할 수 없음.
        
        for(Chef chef : chefs) {
        	chef.eat();
        	chef.cook();	// ?? => 다형성 활용 불가. 동적바인딩 불가.
        					// abstract로 구현하면 접근 가능
        }
        
    }
}
