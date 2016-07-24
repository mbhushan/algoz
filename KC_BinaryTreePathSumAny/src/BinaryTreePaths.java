import java.util.Stack;

class Node {
	Node left;
	Node right;
	Integer data;
	
	public Node(Integer value) {
		this.data = value;
		this.left = null; this.right = null;
	}
}
public class BinaryTreePaths {
	public static int [] C = {7, 5, 12, 3 , 6, 9, 15, 1, 4, 8, 10, 13, 17};
	public static Node root = null;
	
	
	public static void main(String [] args) {
		root = buildBST(root, C);
		printInorder(root);
		printPreOrder(root);
		int [] buff = new int[100];
		System.out.println("printing path(s):");
		findSum(root, 12, buff, 0);
	}
	
	public static void findSum(Node node, int sum, int [] buffer, int level) {
		if (node == null) { return; }
		int temp = sum;
		buffer[level] = node.data;
		
		//look up through the path we have traversed to see if we have found the sum.
		for (int i=level; i>=0; i--) {
			temp = temp - buffer[i];
			if (0 == temp) {
				printPathSum(buffer, i, level);
			}
		}
		findSum(node.left, sum, buffer, level+1);
		findSum(node.right, sum, buffer, level+1);
	}
	
	public static void printPathSum(int [] buffer, int start, int end) {
		int len = buffer.length;
		for (int i=start; i<=end; i++) {
			System.out.print(buffer[i] + " -> ");
		}
		System.out.println("null");
	}

	public static void printPreOrder(Node node) {
		if (null == node) { return ; }
		Stack<Node> stack = new Stack<Node>();
		
		System.out.println("printing preorder: ");
		while (null != node || !stack.isEmpty()) {
			System.out.print(node.data + " ");
			if (null != node.right) {
				stack.push(node.right);
			}
			node = node.left;
			if (null == node && !stack.isEmpty()) {
				node = stack.pop();
			}
		}
		
		System.out.println();
	}
	
	public static void printInorder(Node node) {
		if (null == node) { return ; }
		Stack<Node> stack = new Stack<Node>();
		System.out.println("printing inorder: ");
		while (null!= node || !stack.isEmpty()) {
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
		System.out.println();
	}
	
	public static Node buildBST(Node node, int [] C) {
		if (null == C) { return null; }
		int len = C.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, C[i]);
		}
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
		if (null == node) {
			return new Node(value);
		} else {
			if (value <= node.data) {
				node.left = insertIntoBST(node.left, value);
			} else {
				node.right = insertIntoBST(node.right, value);
			}
			return node;
		}
	}
	
	
}
