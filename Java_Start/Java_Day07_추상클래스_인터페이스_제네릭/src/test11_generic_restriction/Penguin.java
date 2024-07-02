package test11_generic_restriction;

public class Penguin extends Bird implements AbleToSwim {

    @Override
    public void swim() {
        System.out.println("펭귄은 날 수는 없고 수영만 할 수 있습니다.");
        
    }

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
    
}
