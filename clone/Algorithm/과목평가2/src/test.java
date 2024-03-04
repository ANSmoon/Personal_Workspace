import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(reader.readLine());
		int index = 1;
		
		while(index <= total) {
			String str = new String();
			int[] arr = new int[30];
			int x = 0;
			for(int i = 0; i < 3; i++) {
				str = reader.readLine();
				StringTokenizer token = new StringTokenizer(str);
				while(token.hasMoreTokens()) {
					arr[x++] = Integer.parseInt(token.nextToken());	
				}
			}
			int sum = 0;
			int max = 0;
			// 해당 요일부터 약 7일간 더해가며 더한값이 가장 큰 값을 출력
			for (int i = 0; i < 23; i++) {
				for (int j = i; j < i + 7; j++) {
					sum += arr[j];
				}
				max = Math.max(max, sum);
				sum = 0;
			}
			System.out.println();
			System.out.println("#" + index + " " + max);
			index++;
		}
		reader.close();
		
	}
}
