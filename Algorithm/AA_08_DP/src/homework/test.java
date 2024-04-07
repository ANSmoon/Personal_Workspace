package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    static int[][] map;
    static int N, K;
    static int maxDistance; // 최대 등산로 길이
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 방향

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxDistance = 0;

            int maxHeight = 0; // 최고 봉우리의 높이
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            // 가장 높은 봉우리의 위치를 찾아서 DFS 수행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        dfs(i, j, 1, false);
                    }
                }
            }

            System.out.println("#" + t + " " + maxDistance);
        }
    }

    static void dfs(int r, int c, int distance, boolean used) {
        maxDistance = Math.max(maxDistance, distance); // 최대 등산로 길이 갱신

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                // 현재 위치보다 낮은 곳으로만 이동 가능
                if (map[nr][nc] < map[r][c]) {
                    dfs(nr, nc, distance + 1, used);
                } else {
                    // 공사를 한적 없고, 공사 가능하다면 공사 후 이동
                    if (!used && map[nr][nc] - K < map[r][c]) {
                        int temp = map[nr][nc];
                        map[nr][nc] = map[r][c] - 1;
                        dfs(nr, nc, distance + 1, true);
                        map[nr][nc] = temp; // 되돌리기
                    }
                }
            }
        }
    }
}
