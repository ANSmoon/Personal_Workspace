/*
 * Author : 문범수
 * Date : 2024-04-01
 * subject : 
 * main : DFS
 * issue : visited 처리 오류
 * name : hikingTrail.java
 * duration : 300m
 * CodeNo : 1949
 */
 
package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class hikingTrail {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<Integer> list; // 가장 높은 봉우리 넣기[x, y좌표]
    static int N, K, max, result; // N : size, K : 낯출 수 있는 최대 높이, max 가장 높은 높이
    static StringTokenizer token;
 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(reader.readLine());
 
        for (int index = 1; index <= total; index++) {
            token = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            max = Integer.MIN_VALUE;
            result = 0;
            matrix = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(token.nextToken());
                    max = Math.max(matrix[i][j], max);
                }
            }
             
            // 최고 높이 x, y 좌표 순서대로 삽입
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == max) {
                        list.add(i); // x 좌표 입력
                        list.add(j); // y 좌표 입력
                    }
                }
            }
             
            for (int i = 0; i < list.size(); i = i + 2) {
                int row = list.get(i);
                int col = list.get(i + 1);
                visited[row][col] = true;
                dfs(row, col, 1, 0);
                visited[row][col] = false;
            }
            System.out.println("#" + index + " " + result + " ");
        }
    }
     
    // depth : 등산로 길이
    // cnt : 낮춘 횟수
    static void dfs(int row, int col, int depth, int cnt) {
        result = Math.max(result, depth);
 
        for (int k = 0; k < 4; k++) {
            int x = row + dr[k];
            int y = col + dc[k];
            if (x >= 0 && y >= 0 && x < N && y < N && !visited[x][y]) {
                // 높이가 낮은 경우
                if (matrix[row][col] > matrix[x][y]) {
                    visited[x][y] = true;
                    dfs(x, y, depth + 1, cnt);
                    visited[x][y] = false;
                }
                 
                // 높이를 높거나 같은 경우
                else {
                    // 이미 낮춘 경우 불가능
                    if (cnt == 1) {
                        continue;
                    }
                    else{
                        // 낮출수 있는경우
                        // 높이가 같은 경우
                        if (matrix[x][y] == matrix[row][col]) {
                            matrix[x][y]--;
                            visited[x][y] = true;
                            dfs(x, y, depth + 1, cnt + 1);
                            matrix[x][y]++;
                            visited[x][y] = false;
                        }
                         
                        // 높이가 높은경우
                        // 여기 K값을 고려한 빼기가 이뤄져야함
                        else {
                            int tmp = matrix[x][y];
                            if(matrix[x][y] - (matrix[row][col] - 1) <= K) {
                                matrix[x][y] = matrix[row][col] - 1;
                            }else {
                                continue;
                            }
                            visited[x][y] = true;
                            dfs(x, y, depth + 1, cnt + 1);
                            matrix[x][y] = tmp;
                            visited[x][y] = false;
                        }
                    }
                }
            }
        }
    }
}