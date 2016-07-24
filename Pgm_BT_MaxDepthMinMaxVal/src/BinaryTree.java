
public class BinaryTree {
	private Node root;
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data)  { left = null; right = null; this.data = data; }
	}
	
	public BinaryTree() { root = null; }
	
	public void insert(int value) {
		root = insert(root,value);
	}
	
	public int maxDepth() {
		return maxDepth(root);
	}
	
	public int minValue() {
		if (null  != root) {
			return minValue(root);
		} else {
			System.out.println("Tree is EMPTY!!");
			return -1;
		}
	}
	
	public int maxValue() {
		if (null != root) {
			return maxValue(root);
		} else {
			return -1;
		}
	}
	
	private int maxValue(Node node) {
		Node ptr = node;
		
		while (null != ptr.right) {
			ptr = ptr.right;
		}
		
		return ptr.data;
	}
	
	
	private int minValue(Node node) {
		Node ptr = node;
		
		while (null != ptr.left) {
			ptr = ptr.left;
		}
		
		return ptr.data;
	}
	
	private int maxDepth(Node node) {
		if (null == node) { return 0; }
		else {
			int ldepth = maxDepth(node.left);
			int rdepth = maxDepth(node.right);
			
			return (ldepth > rdepth) ? (ldepth+1): (rdepth+1);
		}
	}
	
	public void printBT() {
		if (null != root) {
			printTree(root);
			System.out.println();
		} else {
			System.out.println("null");
		}
	}
	
	private void printTree(Node node) {
		if (null != node.left) {
			printTree(node.left);
		}
		System.out.print(node.data + " ");
		if (null  != node.right) {
			printTree(node.right);
		}
	}
	
	private Node insert(Node node, int value) {
		if (null == node) { return new Node(value); }
		
		if (value  <= node.data) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}
		return node;
	}
}
