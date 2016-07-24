import java.util.Stack;


public class BinaryTree {
	private static Node root = null;
	
	public static void main(String[] args) {
		int [] A = {50, 17, 76, 9, 23, 54, 14, 19, 72, 12, 67};
		root = buildBST(root, A);
		System.out.println("Printing inorder: ");
		printBST(root);
		System.out.println();
		System.out.println("Printing spiral level order: ");
		printSpiralLevelOrder(root);
	}
	
	public static void printSpiralLevelOrder(Node node) {
		if (node == null) { return ; }
		Stack<Node> stackOne = new Stack<Node>();
		Stack<Node> stackTwo = new Stack<Node>();
		stackOne.add(node);
		
		while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {		
			while (!stackOne.isEmpty()) {
				Node temp = stackOne.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					stackTwo.push(temp.left);
				}
				if (temp.right != null) {
					stackTwo.push(temp.right);
				}
			}
			System.out.println();
			while (!stackTwo.isEmpty()) {
				Node temp = stackTwo.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null) {
					stackOne.push(temp.right);
				}
				if (temp.left != null) {
					stackOne.push(temp.left);
				}
			}
			System.out.println();
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
		if (node == null) { return new Node(value); }
		
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}
	
	private static void printBST(Node node) {
		if (node == null) { return ; }
		if (node.left != null) {
			printBST(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			printBST(node.right);
		}
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
