package day_1_10;

public class Variable {
	public static void main(String[] args) {
		
		System.out.println(!true);
		System.out.println(~(-1)); //보수에 대한 내용
		
		int x = 5;
		int y = 2;
		int h = 3;
		h += 3;
		float b = 1.0f;
		
		System.out.println(x / y);
		System.out.println(x % y);
		System.out.println(x++);
		System.out.println(x++);
		System.out.println(x++ + x++);
		System.out.println(2 << 3);
		System.out.println(0.1f == 0.1);
		System.out.println(b);
		System.out.println(-1 & 1);
		System.out.println(true && false);
		System.out.println(h);
		
		byte z = (byte)256;
		System.out.println(z);
		
		
	}
}
