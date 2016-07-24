import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class BTIterative {
	private Node root;
	
	public BTIterative() {
		root = null;
	}
	
	public void inorder() {
		System.out.println("Iterative inorder: ");
		inorderIterative(this.root);
		System.out.println("null");
	}
	
	public void postorder() {
		System.out.println("iterative postorder: ");
		preorderIterative(this.root);
		System.out.println("null");
	}
	
	public void levelOrder() {
		System.out.println("level order of BT: " );
		levelOrder(this.root);
	}
	
	public void printLevelOrder() {
		System.out.println("level order using marker: ");
		printLevelOrderBT(this.root);
	}
	
	public void levelOrderTwoQ() {
		System.out.println("Level order using 2 Queues:");
		levelOrderTwoQ(this.root);
	}
	
	private void levelOrderTwoQ(Node root) {
		if (null == root) { return ;}
		
		Queue<Node> firstQ = new LinkedList<Node>();
		Queue<Node> secondQ = new LinkedList<Node>();
		
		firstQ.add(root);
		
		while (!firstQ.isEmpty() || !secondQ.isEmpty()) {
			while (!firstQ.isEmpty()) {
				Node node = firstQ.remove();
				System.out.print(node.data + " ");
				if (node.left != null) {
					secondQ.add(node.left);
				}
				if (node.right != null) {
					secondQ.add(node.right);
				}
			}
			System.out.println();
			
			while (!secondQ.isEmpty()) {
				Node node = secondQ.remove();
				System.out.print(node.data + " ");
				if (node.left != null) {
					firstQ.add(node.left);
				}
				if (node.right != null) {
					firstQ.add(node.right);
				}
			}
			System.out.println();
		}
	}
	
	private void printLevelOrderBT(Node root) {
		if (null == root) { return ; }
		Queue<Node> queue = new LinkedList<Node>();
		Node marker = new Node(Integer.MIN_VALUE);
		queue.add(root);
		queue.add(marker);
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			
			if (node.equals(marker)) {
				System.out.println();
				
				if (!queue.isEmpty()) {
					queue.add(marker);
				}
				
			} else {
				System.out.print(node.data + " ");
			}
			
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		
	}
	
	private void levelOrder(Node node) {
		if (null == node) { return ; }
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			Node tempNode = queue.remove();
			System.out.print(tempNode.data + " -> ");
			
			if (tempNode.left != null) {
				queue.add(tempNode.left);				
			}			
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
		System.out.println("null");
	}
	
	private void preorderIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		while (node != null || !stack.isEmpty()) {
			
			if (node == null) {
				while (!stack.isEmpty() && (node == stack.peek().right)) {
					node = stack.pop();
					System.out.print(node.data + " -> ");
				}
				node = stack.isEmpty()? null : stack.peek().right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
	}
	
	private void inorderIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		while (node != null || !stack.isEmpty()) {
			
			if (null == node) {
				node = stack.pop();
				System.out.print(node.data + " -> ");
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
	}
	
	public void preorder() {
		System.out.println("Iterative PreOrder:");
		preOrderIterative(this.root);
		System.out.println("null");
	}
	
	private void preOrderIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();

		while (node != null || !stack.isEmpty()) {
			if (null == node) {
				node = stack.pop();
			}
			
			System.out.print(node.data + " -> ");
		
			if (node.right != null) {
				stack.push(node.right);
			}	
			node = node.left;
		}
	}
	
	public void buildBST(int [] input) {
		int len = input.length;
		
		for (int i=0; i<len; i++) {
			this.root = buildBST(this.root, input[i]);
		}
	}
	
	private Node buildBST(Node node, int value) {
		if (null == node) {
			return (new Node(value));
		} else {
			if (value <= node.data) {
				node.left = buildBST(node.left, value);
			} else {
				node.right = buildBST(node.right, value);
			}
			return node;
		}
	}
	
	public void printBST() {
		System.out.println("Print BST: ");
		printBST(this.root);
		System.out.println("null");
	}
	
	private void printBST(Node node) {
		if (null == node) {
			return;
		} else {
			printBST(node.left);
			System.out.print(node.data + " -> ");
			printBST(node.right);
		}
	}
}
