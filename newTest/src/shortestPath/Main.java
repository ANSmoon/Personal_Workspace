/*
 * Author : 문범수
 * Date : 2024-07-04
 * subject :
 * page :
 * main :
 * issue :
 * name : Main.java
 * duration : h
 * no : 1753
 */

package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K, dep, dest, weight;
    static int[] ans;
    static int[][] graph;
    static StringTokenizer token;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        token = new StringTokenizer(reader.readLine());
        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(reader.readLine());
        dep = 0;
        dest = 0;
        weight = 0;
        graph = new int[V + 1][V + 1];
        ans = new int[V + 1];

        // 정점간의 가중치의 정보를 담은 graph를 2차원 배열에 저장
        for(int i = 1; i <= E; i++){
            token = new StringTokenizer(reader.readLine());
            dep = Integer.parseInt(token.nextToken());
            dest = Integer.parseInt(token.nextToken());
            weight = Integer.parseInt(token.nextToken());

            // 저장된 가중치가 0일 경우 그대로 삽입
            if(graph[dep][dest] == 0){
                graph[dep][dest] = weight;
            }

            // 저장된 가중치가 있을경우 비교해서 작은 값을 삽입
            else{
                graph[dep][dest] = Math.min(weight, graph[dep][dest]);
            }
        }

        // 입력 test
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                // 1과 연결된 간선의 가중치 저장
                if(i == 1 && graph[i][j] != 0) {
                    ans[j] = graph[i][j];
                }
            }
        }



        for(int i = 1; i <= V; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
