import java.util.Arrays;

public class KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";

		KMP(text, pattern);
	}

	private static void KMP(String T, String P) {
		// failure function array
		int[] pi = getPi(P);
		System.out.println(Arrays.toString(pi));

		int j = 0; // pattern 의 index
		// i => text의 index
		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1]; // jump
			}

			// 같다면
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					System.out.println((i - P.length() + 1) + "에서 시작하면 찾앗습니다.");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	private static int[] getPi(String P) {
		// 부분문자열 중 prefix, suffix가 일치하는 최대길이을 담을 배열
		int[] pi = new int[P.length()]; // 0 ~ i까지의 부분문자열을 뽑느다.

		int j = 0; // 여기위치 까지는 괜찮음
		for (int i = 1; i < P.length(); i++) {

			// 지금 두개의 포인트가 가리키는 값이 다르면
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (P.charAt(i) == P.charAt(j)) {
				// i번째의 최대 길이는 ++j 한 값이 들어있다.
				pi[i] = ++j;
			}
		}
		return pi;
	}
}