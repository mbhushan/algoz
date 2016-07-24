import java.util.Stack;


public class BinaryTree {
	class Node  {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void postOrderIterative() {
		Stack<Node> stack = new Stack<Node> ();
		Node node =  root;
		System.out.println("postorder traversal: ");
		while (!stack.isEmpty() || node != null) {
			if (node == null)  {
				while (!stack.empty() && node == stack.peek().right) {
	                node = stack.pop();
	                System.out.print(node.data + " ");
	            }
	            node = stack.empty() ? null : stack.peek().right;
			}
			
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
	public void preOrderIterative() {
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		System.out.println("preorder traversal: ");
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				node = stack.pop();
			}
			
			System.out.print(node.data  + " ");
			if (node.right  != null) {
				stack.push(node.right);
			}
			node = node.left;
		}
		System.out.println();
	}
	
	public void InorderIterative() {
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		System.out.println("Iterative inorder: ");
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	public void printBTInorder() {
		System.out.println("printing inorder traversal: ");
		printInorder(root);
		System.out.println();
	}
	private void printInorder(Node node) {
		if (null == node) { return ; }
		printInorder(node.left);
		System.out.print(node.data  + " ");
		printInorder(node.right);
	}
	
	public void buildBinaryTree(int []A) {
		for (int i=0; i<A.length; i++) {
			root = insertIntoBT(root, A[i]);
		}
	}
	
	private Node insertIntoBT(Node node, int value) {
		if (null == node) {
			return new Node(value);
		}
		if (value <= node.data) {
			node.left = insertIntoBT(node.left, value);
		} else {
			node.right = insertIntoBT(node.right, value);
		}
		return node;
	}
}
 