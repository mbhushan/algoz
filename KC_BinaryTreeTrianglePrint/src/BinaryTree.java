import java.util.Stack;

//7:45 am
public class BinaryTree {

	
	public static void main(String [] args) {
		Node root = null;
		int [] A = {10, 5, 15, 2, 7, 13, 19, 1, 3, 6, 9, 12, 14, 17, 20 };
		
		root = buildBST(root, A);
		System.out.println("inorder iterative: ");
		inorder(root);
		System.out.println();
		System.out.println("printing leafs: ");
		printLeafs(root);
		System.out.println();
		System.out.println("printing left edges: ");
		printLeftEdgeNodes(root);
		System.out.println();
		System.out.println("printing right edges: ");
		printRightEdgeNodes(root);
		System.out.println();
		System.out.println("Leaf Count: " + leafCount(root));
	}
	
	
	private static int leafCount(Node node) {
		if (null == node) { return 0; }
		
		if (null == node.left || null == node.right) {
			return 1;
		}
		
		return  (leafCount(node.left) + leafCount(node.right));
	}
	
	private static void printRightEdgeNodes(Node node) {
		if (null == node) { return ; }
		
		System.out.print(node.data + " ");
		
		printRightEdgeNodes(node.right);
	}
	private static void printLeftEdgeNodes(Node node) {
		if (null == node) { return ; }
		
		System.out.print(node.data + " ");
		
		printLeftEdgeNodes(node.left);
	}
	
	private static void printLeafs(Node node) {
		if (null == node) { return ; }
		
		if (node.left == null && node.right == null) { 
			System.out.print(node.data + " ");
		}
		
		printLeafs(node.left);
		printLeafs(node.right);
	}
	
	private static void inorder(Node node) {
		if (null == node) { return; }
		
		Stack<Node> stack = new Stack<Node> ();
		
		while ((null != node) || !stack.isEmpty()) {
			if (null != node) {
				stack.push(node);
				node = node.left;
			}
			
			if (null == node) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (null == A) { return node; }
		
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
}

class Node {
	Integer data;
	Node left;
	Node right;
	
	Node(Integer data) {
		this.data = data;
		left = null; right = null;
	}
}
