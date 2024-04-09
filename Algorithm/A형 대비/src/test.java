import java.util.*;

class StemCell {
    int x, y, life, time;

    public StemCell(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.time = life; // 초기 생명력 값으로 초기화
    }
}

public class test {
    static int N, M, K;
    static int[][] grid;
    static Queue<StemCell> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();

            grid = new int[N][M];
            queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int life = scanner.nextInt();
                    grid[i][j] = life;
                    if (life > 0) {
                        queue.offer(new StemCell(i, j, life));
                    }
                }
            }

            simulate();

            System.out.println("#" + t + " " + countAliveCells());
        }
    }

    static void simulate() {
        while (K-- > 0) {
            int size = queue.size();

            Queue<StemCell> newQueue = new LinkedList<>();

            while (size-- > 0) {
                StemCell cell = queue.poll();

                if (cell.time > 0) {
                    cell.time--;

                    if (cell.time == 0) {
                        for (int i = 0; i < 4; i++) {
                            int nx = cell.x + dx[i];
                            int ny = cell.y + dy[i];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && grid[nx][ny] == 0) {
                                grid[nx][ny] = cell.life;
                                newQueue.offer(new StemCell(nx, ny, cell.life));
                            }
                        }
                    }
                }

                newQueue.offer(cell);
            }

            queue = newQueue;
        }
    }

    static int countAliveCells() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
