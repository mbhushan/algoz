import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	
	Node () { data = 0; left = null; right = null;  }
}
public class BinaryTree {
	static Node root = null;
	static final int N = 7;
	
	public static void main(String[] args) {
		root = createBinarySearchTree(root);
		printBST(root);
//		root = buildBST(root, 100);
//		root = buildBST(root, 200);
//		root = buildBST(root, 300);
		System.out.println();
		boolean temp = isHeightDifferenceMoreThanOne(root);
		System.out.println("isHeightDifferenceMoreThanOne: " + temp);
	}
	
	public static boolean isHeightDifferenceMoreThanOne(Node root) {
		if (root == null) { return true; }
		else {
			int low = minDepth(root);
 			int high = maxDepth(root);
			System.out.println("Low: " + low);
			System.out.println("High: " + high);
			return ((high - low)  >= 1); 
		}
	}
	
	public static int maxDepth(Node root) {
		if (root == null) { return 0;}
		else {
			int ldepth = maxDepth(root.left);
			int rdepth = maxDepth(root.right);
			
			if (ldepth >= rdepth) { return ldepth+1; }
			else { return rdepth+1; }
		}
	}
	
	public static int minDepth(Node root) {
		if (root == null) { return 0; }
		else  {
			int ldepth = minDepth(root.left);
			int rdepth = minDepth(root.right);
			
			if (ldepth <= rdepth) { return ldepth+1; }
			else { return rdepth+1; }
		}
	}
	
	public static void printBST(Node root) {
		if (root == null) { return; }
		else {
			printBST(root.left);
			System.out.print(root.data + " ");
			printBST(root.right);
		}
	}
	public static Node createBinarySearchTree(Node root) {
		Random rand = new Random();
		for (int i=0; i < N; i++) {
			root = buildBST(root, rand.nextInt(100));
		}
		return root;
	}
	public static Node buildBST(Node node, int value) {
		if (node == null) { return NewNode(value); }
		else {
			if (value <= node.data) {
				node.left = buildBST(node.left, value);
			} else {
				node.right = buildBST(node.right, value);
			}
			return node;
		}
	}
	public static Node NewNode(int value) {
		Node node = new Node();
		node.data = value;
		node.left = null;
		node.right = null;
		
		return node;
	}
}
