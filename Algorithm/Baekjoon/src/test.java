import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 노드의 개수
        ArrayList<Integer>[] tree = new ArrayList[N + 1];
        int[] parent = new int[N + 1];

        // 각 노드의 연결 정보 저장
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // 부모 노드 찾기
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트 노드는 1로 가정

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (int child : tree[current]) {
                if (!visited[child]) {
                    parent[child] = current;
                    queue.offer(child);
                }
            }
        }

        // 2번 노드부터 순서대로 부모 노드 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}
