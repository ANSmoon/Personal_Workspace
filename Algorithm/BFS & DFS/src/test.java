import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    static int R, C;
    static char[][] field;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; // 상하좌우
    static int[] dc = {0, 1, 0, -1};
    static int sheepCount, wolfCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        field = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = reader.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        sheepCount = 0;
        wolfCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (field[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
    }

    static void bfs(int startX, int startY) {
        int sheep = 0;
        int wolf = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (field[x][y] == 'o') {
                sheep++;
            } else if (field[x][y] == 'v') {
                wolf++;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d];
                int ny = y + dc[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && field[nx][ny] != '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        if (sheep > wolf) {
            sheepCount += sheep;
        } else {
            wolfCount += wolf;
        }
    }
}
