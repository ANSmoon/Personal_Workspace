import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int data;
	Node left;
	Node right;
	Node parent;

	Node() {
	};

	Node(int data) {
		this.data = data;
	}
}
/*
 * 13 1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */

public class Tree_Practice {
	static Node[] nodes = new Node[14];
	static int[] count = new int[14];

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i < nodes.length; i++) {
			nodes[i] = new Node();
			nodes[i].data = i;
		}
		
		int vertex = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());

		while (token.hasMoreTokens()) {
			int parent = Integer.parseInt(token.nextToken());
			int child = Integer.parseInt(token.nextToken());
			
			count[child]++;

			if(nodes[parent].left == null) {
				nodes[parent].left = nodes[child];
			}else {
				nodes[parent].right = nodes[child];
			}
		}
		int root = -1;
		// root 는 한번도 자식 node가 된적 없는 node를 의미
		for(int i = 1; i < nodes.length; i++) {
			if(count[i] == 0) {
				root = i;
			}
		}	
		preorder(nodes[root]);
	}
	
	static void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
}