
public class BST {
	private static Node root;
	
	public static void main(String [] args) {
		int [] A = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		root = buildBST(root, A);
		System.out.println("inorder: ");
		printBSTInorder(root);
		System.out.println();
		int sizeBST = sizeOfBST(root);
		System.out.println("Size of BST: " + sizeBST);
		
		for (int i=1; i<=sizeBST; i++) {
			Node node = nthLargestNode(root, i);
			System.out.println(i + " largest node: " + node.data);
		}
	}
	
	public static Node nthLargestNode(Node node, int N) {
		if (null == node) {
			return null;
		}
		int R = sizeOfBST(node.left) + 1;
		if (N == R) {
			return node;
		}
		if (N < R) {
			return nthLargestNode(node.left, N);
		} else {
			return nthLargestNode(node.right, N-R);
		}
	}
	
	public static int sizeOfBST(Node node) {
		if (null == node) { return 0; }
		return (sizeOfBST(node.left) + 1 + sizeOfBST(node.right));
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (A == null) { return null; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
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
	
	public static void printBSTInorder(Node node) {
		if (null == node) {  return ; }
		if (null != node.left) {
			printBSTInorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			printBSTInorder(node.right);
		}
	}
}

class Node {
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
