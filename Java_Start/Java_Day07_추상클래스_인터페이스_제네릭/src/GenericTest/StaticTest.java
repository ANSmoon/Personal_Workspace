package GenericTest;

class Haha {
	static int a = 5;
	
//	public void instanceM() {
//		System.out.println("Haha");
//	}
//	
	public static void staticM() {
		System.out.println("Haha");
	}
}

class Hoho extends Haha {
	int a = -100;
	
//	public void instanceM() {
//		System.out.println("Hoho");
//	}
//	
	public static void staticM() {
		System.out.println("Hoho");
	}
}

public class StaticTest {
	public static void main(String[] args) {
		Haha ha = new Haha();
		Hoho ho = new Hoho();
		
		System.out.println(ha.a++);
		System.out.println(ho.a++);
		System.out.println(Haha.a);		
		
		Haha ha3 = new Hoho();
		
//		ha3.instanceM();
		ha3.staticM();
		
		
		
		
	}
}
