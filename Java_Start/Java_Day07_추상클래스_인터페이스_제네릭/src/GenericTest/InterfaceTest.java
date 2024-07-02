package GenericTest;

interface Kkulkkul {
	public static final int a = 5;
	public default void smile() {
		System.out.println("Kkulkkul");
	}
	
	public static void smile2() {
		System.out.println("Kkulkkul2");
	}
}

interface Kkalkkal {
	public default void smile() {
		System.out.println("Kkalkkal");
	}
	
//	public static void smile2() {
//		System.out.println("Kkalkkal2");
//	}
}

class Haha {
	public void smile() {
		System.out.println("Haha");
	}
}

class Hoho extends Haha implements Kkulkkul {
	
}

class Hehe implements Kkalkkal, Kkulkkul {
	
}

public class InterfaceTest {
	public static void main(String[] args) {
		Hoho h = new Hoho();
		h.smile();
//		System.out.println(h.a);

	}
}
