import java.util.Random;
import java.util.Stack;


public class BST {
	public static Node root1 = null;
	public static Node root2 = null;
	public static final int N = 7;
	public static final int RANGE = 100;
	
	public static void main(String[] args) {
		System.out.println("Building first BST with values:");
		root1 = buildBST(root1);
		
		System.out.println("Building second BST with values:");
		root2 = buildBST(root2);
		
		System.out.println("printing 2 BSTs in ascending order: ");
		printTwoBSTsInorder(root1, root2);
	}
	
	public static void printTwoBSTsInorder(Node r1, Node r2) {
		Stack<Node> stk1 = new Stack<Node>();
		Stack<Node> stk2 = new Stack<Node>();
		boolean isFinished = false; 
		while (!isFinished) {
			if (r1 != null && r2 != null) {
				stk1.push(r1);
				r1 = r1.left;
				stk2.push(r2);
				r2 = r2.left;
			} else if (r1 != null && r2 == null) {
				stk1.push(r1);
				r1 = r1.left;
			} else if (r1 == null && r2 != null) {
				stk2.push(r2);
				r2 = r2.left;
			} else if (r1 == null && r2 == null) {
				if (!stk1.isEmpty() && stk2.isEmpty()) {
					r1 = stk1.pop();
					System.out.print(r1.data + " ");
					r1 = r1.right;
				} else if (stk1.isEmpty() && !stk2.isEmpty()) {
					r2 = stk2.pop();
					System.out.print(r2.data + " ");
					r2 = r2.right;
				} else if (!stk1.isEmpty() && !stk2.isEmpty()) {
					if (stk1.peek().data <= stk2.peek().data) {
						r1 = stk1.pop();
						System.out.print(r1.data + " ");
						r1 = r1.right;
					} else {
						r2 = stk2.pop();
						System.out.print(r2.data + " ");
						r2 = r2.right;
					}
				} else {
					isFinished = true;
				}
			}
		}
	}
	
	public static Node buildBST(Node node) {
		Random rand = new Random();
		
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(99) + 1;
			System.out.print(value + " ");
			node = insertIntoBST(node, value);
		}
		System.out.println();
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
		if (null == node) {
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
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
