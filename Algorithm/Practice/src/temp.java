import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class temp {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		
		if(x > y) {
			System.out.println(">");
		}else if(x < y) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}
}