
public class String_02_문자열뒤집기 {
	public static void main(String[] args) {
		String str = "Hello SSAFY!!";
		
		char[] charArr = str.toCharArray();
		System.out.println(charArr);

		// SWAP 횟수 = str 길이 절반
		for (int i = 0; i < str.length() / 2; i++) {
			char temp = charArr[i];
			charArr[i] = charArr[str.length()- 1 - i];
			charArr[str.length()- 1 - i] = temp;
		}
		System.out.println(charArr);
	}
}
