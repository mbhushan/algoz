import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderBST {
	
	private static Node root = null;
	private static Node root1 = null;
	public static void main(String[] args) {
//		int [] A = {12, 9, 15, 6, 10, 13, 17, 4, 7, 1, 5, 8};
//		root = buildBST(root, A);
//		System.out.println("Printing inorder recursively: ");
//		inorderRecur(root);
//		System.out.println();
//		System.out.println("Printing level order traversal of BST: ");
//		printLevelOrder(root);
		
		int [] B = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		root1 = buildBST(root1, B);
		System.out.println("Printing inorder recursively: ");
		inorderRecur(root1);
		System.out.println();
		System.out.println("Printing level order traversal of BST: ");
		printLevelOrder(root1);
	}
	
	public static void printLevelOrder(Node node) {
		if (node == null) { return ;}
		Queue<Node> queue = new LinkedList<Node>();
		Node marker = new Node(null);
		queue.add(node);
		queue.add(marker);
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			if (temp.equals(marker)) {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(marker);
				}
			} else {
				System.out.print(temp.data + " ");
				if (temp.left != null) {
						queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
			}
			}
		}
		
	}
	
	public static void inorderRecur(Node node) {
		if (node == null) { return ; }
		if (node.left != null) {
			inorderRecur(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inorderRecur(node.right);
		}
	}
	
	public static Node buildBST(Node node, int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}
	
}

class Node {
	Integer data;
	Node left;
	Node right;
	public Node(Integer data) {
		this.data = data;
		left = null; right = null;
	}
}
