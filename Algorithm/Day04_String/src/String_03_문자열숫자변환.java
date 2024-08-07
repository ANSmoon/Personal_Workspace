public class String_03_문자열숫자변환 {
	public static void main(String[] args) {
		String str = "123";
		int result = atoi(str);
		System.out.println(result);
	}

	static int atoi(String str) {
		int value = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if('0' <= c && c <='9') {
				// 10씩 곱해서 왼쪽으로 bit를 옮기는 방식
				// 핵심은 '0'을 뺌으로써 문자에서 정수로 바뀌는 logic
				value = (value * 10) + (c-'0');
			}else {
				System.out.println("정수가 아님");
				return -1;
			}
			
		}
		return value;
	}
}