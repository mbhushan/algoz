import java.util.Random;
import java.util.Stack;


public class BinaryTree {
	
	private static int N = 7;
	private static Node root = null;
	public static int K = 3;
	private static int INDEX = 0;
	public static void main(String [] args) {
		root = buildBST(root);
		System.out.println("Printing inorder: ");
		inorder(root);
		System.out.println();
		System.out.println("K value: " + K);
		findKthSmallestIterative(root);
		findKthSmallesRecursive(root);
	}
	
	public static void findKthSmallesRecursive(Node node) {
		Stack<Node> stack = new Stack<Node>();
		int i=1;
		while (!stack.isEmpty() || node != null) {
			
			if (node == null) {
				node = stack.pop();
				if (i == K) {
					System.out.println("Kth Node :" + node.data);
				}
				++i;
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
	}
	
	public static void findKthSmallestIterative(Node node) {		
		if (node == null) { 
			System.out.println("Tree is empty!!");
			return;
		}		
		if (node.left != null) {
			findKthSmallestIterative(node.left);
		}
		
		++INDEX;
		if (K == INDEX) {
			System.out.println("Kth Smallest Node Value: " + node.data);
			return;
		} 		
		
		if (node.right != null) {
			findKthSmallestIterative(node.right);
		}
	}
	
	public static void inorder(Node node) {
		if (node ==  null) { return ; }
		
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}
	
	public static Node buildBST(Node node) {
		Random rand = new Random();
		
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(99) + 1;
			node = buildBST(node, value);
			System.out.print(value + " ");
		}
		System.out.println();
		
		return node;
	}
	
	private static Node buildBST(Node node, int data) {
		if (node == null) { return new Node(data); }
		
		if (data <= node.data) {
			node.left = buildBST(node.left, data);
		} else {
			node.right = buildBST(node.right, data);
		}
		return node;
	}
}

class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}