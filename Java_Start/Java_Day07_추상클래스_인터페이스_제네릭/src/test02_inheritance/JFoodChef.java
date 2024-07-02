package test02_inheritance;

public class JFoodChef extends Chef {
    
    @Override
    public void cook() {
        System.out.println("일식을 조리한다.");
    }
}
