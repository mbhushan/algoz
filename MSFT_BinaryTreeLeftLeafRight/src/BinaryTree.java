import java.util.Random;


class Node  {
	int data;
	Node left;
	Node right;
	
	public Node() { data = 0; left = null ; right = null ;  }
}

public class BinaryTree {
	private static final int N = 11;
	private static Node root;
	private static int [] A = {42, 98, 85, 9, 5, 95, 34, 12, 48, 8, 80};
	
	public static void main(String [] args) {
		root = buildBinaryTree(root);
		printBinaryTree(root);
		System.out.println();
		printLeftLeafRight(root);
	}
	
	public static void printLeftLeafRight(Node root) {
		printLeft(root);
		System.out.println();		
		printRight(root);
		System.out.println();		
		printLeafs(root);
		System.out.println();
		System.out.println(root.data);
	}
	
	public static void printLeafs(Node node) {
		if (null == node) { return ; }
		else {
			printLeafs(node.left);
			if ((null == node.left) && (null == node.right)) { 
				System.out.print(node.data  + " ");				
			}
			printLeafs(node.right);
		}
	}
	public static void printLeft(Node node) {
		if (null == node.left) { return ;}
		else if (null == node.left.left && null != node.left.right) {
			System.out.print(node.left.data);
		} else  {
			while (null != node.left.left) {
				System.out.print(node.left.data + " ");
				node = node.left;
			}
			if (node.left.right != null) {
				System.out.print(node.left.data);
			}
		}
	}
	
	public static void printRight(Node node) {
		if (null == node.right) {	return;}
		else if (null == node.right.right && null != node.right.left) {
			System.out.print(node.right.data);
		}
		else {
			while (null != node.right.right) {
				System.out.print(node.right.data + " ");
				node = node.right;
			}
			if (node.right.left != null) {
				System.out.print(node.right.data);
			}
		}
	}
	public static Node buildBinaryTree(Node node) {
		Random rand = new Random();
		
		for (int i=0; i<N; i++) {
			int nodeData =  rand.nextInt(100);
			System.out.print(A[i] + " ");
			//System.out.print(nodeData  +  " ");
			node = insertIntoBinaryTree(node, A[i]);
		}
		System.out.println();
		return node;
	}
	
	public static void printBinaryTree(Node node) {
		if (null == node) { return ;}
		else {
			printBinaryTree(node.left);
			System.out.print(node.data + " ");
			printBinaryTree(node.right);
		}
	}
	
	public static Node insertIntoBinaryTree(Node node, int value) {
		if (null == node) { return newNode(value); }
		else  {
			if (value  <= node.data)  {
				node.left = insertIntoBinaryTree(node.left, value);
			} else  {
				node.right = insertIntoBinaryTree(node.right, value);
			}
			return node;
		}
	}
	
	public static Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		return node;
	}
}
