import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            sb.append("#" + T);

            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] map = new int[r][3];
            int blue = 0;

            for (int i = 0; i < r; i++) {
                char[] ch = br.readLine().toCharArray();

                for (int j = 0; j < c; j++) {
                    if (ch[j] == 'W') {
                        map[i][0]++;
                    } else if (ch[j] == 'R') {
                        map[i][2]++;
                    } else {
                        map[i][1]++;
                        blue++;
                    }
                }
            }

            cnt += map[0][1] + map[0][2] + map[r - 1][0] + map[r - 1][1];
            
            int minRepaint = Integer.MAX_VALUE;

            for (int i = 1; i < r - 1; i++) {
                int num = blue;
                
                for (int j = 1; j < i; j++) {
                    num += map[j][2];
                }
                
                for (int j = i; j < r - 1; j++) {
                    num -= map[j][1];
                }
                
                minRepaint = Math.min(minRepaint, num);
            }

            sb.append(" " + (cnt + minRepaint) + "\n");
        }

        System.out.println(sb);
    }
}
