//
//
//class Node {
//	int data;
//	Node left;
//	Node right;
//	
//	Node(int data) {
//		this.data = data;
//		left = null; right = null;
//	}
//}
//public class WAL_BinaryTree {
//	private static int [] A = {8,5,12,2,7,9,15};
//	private static Node root = null;
//	
//	public static void main(String [] args) {
//		root = buildBST(root);
//		System.out.println("Printing BST...");
//		printBST(root);
//		System.out.println();
//	}
//	
//	public static void printBST(Node node) {
//		if (null == node) { return; }
//		else {
//			if (null != node.left) {
//				printBST(node.left);
//			}
//			System.out.print(node.data + " ");
//			if (null != node.right) {
//				printBST(node.right);
//			}
//		}
//	}
//	
//	public static Node buildBST(Node node) {
//		int len = A.length;
//		for (int i=0; i<len; i++) {
//			node = insertIntoBST(node, A[i]);
//		}
//		return node;
//	}
//	
//	public static Node insertIntoBST(Node node, int data) {
//		if (null == node ) { return new Node(data); }
//		else {
//			if (data <= node.data) {
//				node.left = insertIntoBST(node.left, data);
//			} else {
//				node.right = insertIntoBST(node.right, data);
//			}
//			return node;
//		}
//	}
//}
//

