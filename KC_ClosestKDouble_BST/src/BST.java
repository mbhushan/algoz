
public class BST {
	
	private static Node root;
	
	public static void main(String[] args) {
		Double [] A = {3.57, 3.51, 3.62, 3.49, 3.55, 3.59, 3.65, 3.30, 3.52, 3.56};
		root = buildBST(root, A);
		System.out.println("printing inorder of BST: ");
		printInorder(root);
		System.out.println();
		double K = 3.559;
		System.out.println("Closest to " + K + ": " + findClosestK(root, K, 0.0));
	}
	
	public static Double findClosestK(Node node, Double K, double closestK) {
		if (null == node) { return null; }
		if (node.data.compareTo(K) == 0) {
			return K;
		}
		if ((Math.abs(node.data - K)) < (Math.abs(K - closestK))) {
			closestK = node.data;
		}
		if ((K.compareTo(node.data) <= 0) && (null != node.left)) {
				closestK = findClosestK(node.left, K, closestK);
		} else if (null != node.right){
				closestK = findClosestK(node.right, K, closestK);
		}
		return closestK;
	}
	
	public static Node buildBST(Node node, Double [] A) {
		if (null == A) { return null; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	private static Node insertIntoBST(Node node, Double value) {
		if (node == null) { return new Node(value); }
		if (value.compareTo(node.data) <= 0) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}
	
	public static void printInorder(Node node) {
		if (null == node) { return ; }
		if (null != node.left) {
			printInorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			printInorder(node.right);
		}
	}
}

class Node {
	Double data;
	Node left;
	Node right;
	public Node(Double data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
