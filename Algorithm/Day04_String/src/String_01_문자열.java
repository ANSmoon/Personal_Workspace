
public class String_01_문자열 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		
		// 참조 자료형은 == -> hash code를 비교
		// 문자열 값 비교 equals

		if(str1.equals(str2)) {
			System.out.println("equal");
		}
		
		if(str1 != str2) {
			System.out.println("Not equal");
		}

		if(str1 == str3) {
			System.out.println("Equal");
		}
	
	}	
	
}
