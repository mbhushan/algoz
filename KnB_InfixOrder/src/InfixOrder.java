import java.util.Random;
import java.util.Stack;


public class InfixOrder {
	
	private static Node root = null;
	private static int N = 7;
	
	public static void main(String [] args) {
		root = buildBinaryTree(root);
		System.out.println("Printing BST inorder: ");
		printBSTInfix(root);
		System.out.println();
		System.out.println("Printing infix order iteratively: ");
		infixIterative(root);
	}
	
	public static void infixIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				Node top = stack.pop();
				System.out.print(top.data + " ");
				node = top.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
	public static void printBSTInfix(Node node) {
		if (node == null) { return ; }
		else {
			printBSTInfix(node.left);
			System.out.print(node.data + " ");
			printBSTInfix(node.right);
		}
	}
	
	public static void preOrderIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		while (node != null || !stack.isEmpty()) {
			
			if (node == null) {
				node = stack.pop();
			}
			
			System.out.print(node.data + " ");
			
			if (node.right != null) {
				stack.push(node.right);
			}
			node = node.left;
		}
	}
	
	public static Node buildBinaryTree(Node node) {
		System.out.println("These nodes are inserted into BST: ");
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			int data = rand.nextInt(99) + 1;
			node = buildBST(node, data);
			System.out.print(data + " ");
		}
		System.out.println();
		return node;
	}
	
	public static Node buildBST(Node node, int value) {
		if (node == null) {
			return new Node(value);
		} else {
			if (value <= node.data) {
				node.left = buildBST(node.left, value);
			} else {
				node.right = buildBST(node.right, value);
			}
			
			return node;
		}
	}
}

class Node {
	int data;
	Node right;
	Node left;
	
	Node (int data) {
		left = null;
		right = null;
		this.data = data;
	}
}
