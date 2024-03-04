
public class String_04_패턴매칭 {
	public static void main(String[] args) {
		String text = "This iss a book";
		String pattern = "iss";

		int result = patternMathing(text.toCharArray(), pattern.toCharArray());
		System.out.println(result);
	}

	public static int patternMathing(char[] text, char[] pattern) {
		// i : pattern 시작 위치
		// j : 문자 하나씩 비교

		start: for (int i = 0; i <= text.length - pattern.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				if (text[i + j] != pattern[j]) {
					continue start;
				}
				// break가 되지 않았다면
				
			}
			return i;
		}
		return -1;
	}
	
}
