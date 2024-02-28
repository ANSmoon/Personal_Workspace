package GenericTest;

class Haha {
	public void smile() {
		System.out.println("Haha");
	}
}

class Generic<T> {
	T t;

	Generic(T t) {
		this.t = t;
	}
}

public class GenericTest {
	
	public static void main(String[] args) {		
		Generic<Integer> generic = new Generic(100);
		System.out.println(generic.t);
		
//		Haha haha = new Haha();
//		Generic<Haha> generic2 = new Generic(haha);
//		generic2.t.smile();
	}
	
}
