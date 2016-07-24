import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	private static Node root = null;
	private static int N = 7;
	public static void main(String[] args) {
		int [] A = {12, 9, 15, 4, 10, 13, 20, 14, 25, 30};
		root = buildBST(root, A);
		System.out.println("Min Depth Recursive: " + minDepthBT(root, 0));
		System.out.println("Min Depth BFS: " + minDepthBT(root, 0));
		System.out.println("Max Depth: " +(maxDepth(root)-1));
	}
	
	public static int minDepthBFS(Node node) {
		if (node == null) { return 0; }
		Queue<Node> queue = new LinkedList<Node>();
		Node marker = new Node(null);
		queue.add(node);
		queue.add(marker);
		int minDepth = 0;
		
		while (!queue.isEmpty()) {
			if (node.left == null && node.right == null) { return minDepth; }
			
			Node temp = queue.remove();
			if (temp.equals(marker)) {
				if (!queue.isEmpty()) {
					queue.add(marker);
					++minDepth;
				}
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		
		return minDepth;
	}
	
	public static int minDepthBT(Node node, int depth) {
		if ((node == null) || (node.left == null && node.right == null)) { return depth; }
		
		int x = node.left != null ? minDepthBT(node.left, depth+1) : depth;
		int y = node.right != null ? minDepthBT(node.right, depth+1): depth;
		
		return (x > y) ? y : x;
	}
	
	public static int maxDepth (Node node) {
		if (node == null) { return 0; }
		
		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);
		
		return (Math.max(leftDepth, rightDepth) + 1) ;
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
	
	Node(Integer data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
