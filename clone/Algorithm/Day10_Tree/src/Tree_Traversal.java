public class Tree_Traversal {

	// '\0' => 정수 0과 같다
	static char[] tree = new char[] { '\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };

	public static void main(String[] args) {
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}

	// 전위 순회
	// VLR
	static void preorder(int i) {
		if(tree.length <= i || tree[i] == '\0') {
			return;
		}
		
		// Vertex print
		System.out.print(tree[i] + " ");
		preorder(i * 2); // left
		preorder(i * 2 + 1); // right
	}
	
	// 중위 순회
	// LVR
	static void inorder(int i) {
		if(tree.length <= i || tree[i] == '\0') {
			return;
		}
		
		// Vertex print
		inorder(i * 2); // left
		System.out.print(tree[i] + " ");
		inorder(i * 2 + 1); // right
		
	}
	
	// 후위 순회
	// LRV
		static void postorder(int i) {
			if(tree.length <= i || tree[i] == '\0') {
				return;
			}
			
			// Vertex print
			postorder(i * 2); // left
			postorder(i * 2 + 1); // right
			System.out.print(tree[i] + " ");
			
		}
}
