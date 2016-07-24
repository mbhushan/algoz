
public class BinaryTree {
	
	private Node root;
	
	public static class Node {
		Node left;
		Node right;
		int data;
		
		public Node (int value) { left = null; right = null; data = value; }
	}
	
	public BinaryTree() { root = null; }
	
	public void insertIntoBinaryTree(int value) {
		root = insertIntoBinaryTree(root, value);
	}
	
	public int sizeOfBT() {
		return sizeOfBT(root);
	}
	
	private int sizeOfBT(Node node) {
		if (null == node) { return 0; }
		else {
			return (sizeOfBT(node.left) + 1 + sizeOfBT(node.right));
		}
	}
	
	public void printBT() {
		if (null != root) {
			printBT(root);
			System.out.println();
		} else {
			System.out.println("null");
		}
	}
	
	private void printBT(Node node) {
		if (null != node.left) {
			printBT(node.left);
		}
		System.out.print(node.data + " ");
		if (null  != node.right) {
			printBT(node.right);
		}
	}
	
	private Node insertIntoBinaryTree(Node root, int value) {
		if (null == root) { return new Node(value); }
		
		if (value <= root.data) { 
			root.left = insertIntoBinaryTree(root.left, value);
		} else {
			root.right = insertIntoBinaryTree(root.right, value);
		}
		
		return root;
	}
}
