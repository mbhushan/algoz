
public class BinaryTreeTwo {
private Node root;
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data) { left = null; right = null; this.data = data;}
	}
	
	public BinaryTreeTwo() { root = null; }
	
	public Node getBTRoot() { return root; }
	
	public void doubleTree() {
		doubleTree(root);
		printBT();
	}
	
	public void doubleTreeRight() {
		doubleTreeRight(root);
		printBT();
	}
	
	private void doubleTreeRight(Node node) {
		if (null == node) { return; }
		else {
			doubleTreeRight(node.left);
			doubleTreeRight(node.right);
			
			Node right = node.right;
			node.right = new Node (node.data);
			node.right.right = right;
		}
	}
	
	private void doubleTree(Node node) {
		if (null == node) { return; }
		else  {
			doubleTree(node.left);
			doubleTree(node.right);
			
			Node tempLeft = node.left;
			node.left = new Node(node.data);
			node.left.left = tempLeft;
		}
	}
	
	public void mirrorTree() {
		mirrorTree(root);
		printBT();
		mirrorTree(root);
		printBT();
	}
	
	private void mirrorTree(Node node) {
		if (null == node) { return; }
		else {
			mirrorTree(node.left);
			mirrorTree(node.right);
			
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	public void printPaths()  {
		int [] paths = new int[1000];
		printPaths(root, paths, 0);
	}
	
	private void printPaths(Node node, int [] paths, int pathLen) {
		if (null == node) { return ; }
		
		paths[pathLen] = node.data;
		++pathLen;
		
		//we hit a leaf here
		if (null == node.left && null == node.right) {
			printPathArray(paths, pathLen);
		} else {
			printPaths(node.left, paths, pathLen);
			printPaths(node.right, paths, pathLen);
		}
	}
	
	private void printPathArray(int [] paths, int pathLen)  {
		for (int i=0; i<pathLen; i++) {
			System.out.print(paths[i] + " ");
		}
		System.out.println();
	}
	
	public boolean hasPathSum(int sum) {
		return hasPathSum(root, sum);
	}
	
	private boolean hasPathSum(Node node, int sum) {
		if (null == node) { return (0 == sum);  }
		
		int subSum = sum - node.data;
		
		return (
				hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum)
				);
	}
	
	public void insert(int value) {
		root = insert(root,value);
	}
	
	public void printBT() {
		if (null  != root) {
			printBT(root);
			System.out.println();
		} else  {
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
