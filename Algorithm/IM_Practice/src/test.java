import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(reader.readLine());
		int[] arr = new int[total];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for(int i = 0; i < total; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		int V = Integer.parseInt(reader.readLine());
		int cnt = 0;
		for(int i = 0; i < total; i++) {
			if(arr[i] == V) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
