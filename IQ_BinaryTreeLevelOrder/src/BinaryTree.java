import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {

	private static Node root;
	
	public static void main(String [] args) {
		int [] A = {20, 10, 30, 5, 15, 25, 35, 22, 27, 21, 23, 26, 28, 24};
		root = buildBST(root, A);
		System.out.println("printing inorder...");
		inorder(root);
		System.out.println();
		
		System.out.println("printing level order in new line...");
		levelOrder(root);
	}
	
	public static void levelOrder(Node node) {
		if (null == node) { 
			System.out.println("tree is empty!");
		}
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
				if (null != temp.left) {
					queue.add(temp.left);
				}
				if (null != temp.right) {
					queue.add(temp.right);
				}
			}
		}
	}
	
	public static void inorder(Node node) {
		if (null == node ) { return ; }
		if (node.left != null) { 
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}
	public static Node buildBST(Node node, int [] A) {
		if (null == A) { return node; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
		if (null == node) { return new Node(value); }
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}
	
	private static class Node {
		Node left;
		Node right;
		Integer data;
		Node (Integer value) {
			data = value;
			left = null; right = null;
		}
	}
}
/*
printing inorder...
5 10 15 20 21 22 23 24 25 26 27 28 30 35 
printing level order in new line...
20 
10 30 
5 15 25 35 
22 27 
21 23 26 28 
24 
*/