import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	
	Node () {
		data =0;
		left = null; right = null;
	}
}
public class BinaryTreeHeight {
	static Node root;
	static final int N = 15;
	public static void main(String [] args)  {
		root = createBST(root);
		int height = heightOfBT(root);
		printBST(root);
		System.out.println();
		System.out.println("Height of the BST is: " + height);
	}
	
	public static void printBST(Node node)  {
		if (null  == node) { return ; }
		else {
			printBST(node.left);
			System.out.print(node.data + " ");
			printBST(node.right);
		}
	}
	
	public static int heightOfBT(Node root) {
		if (null == root) { return 0; }
		else {
			int ldepth = heightOfBT(root.left);
			int rdepth = heightOfBT(root.right);
			
			if  (ldepth >= rdepth) { return ldepth + 1; }
			else { return rdepth+1; }
		}
	}
	
	public static Node createBST(Node root) {
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			root = buildBinaryTree(root, rand.nextInt(100));
		}
		return root;
	}
	
	public static Node buildBinaryTree(Node root, int value)  {
		if (null == root) { return newNode(value); }
		else {
			if (value  <= root.data) {
				root.left = buildBinaryTree(root.left, value);
			} else  {
				root.right = buildBinaryTree(root.right, value);
			}
			return root;
		}
	}
	
	public static Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		node.left = null;
		node.right = null;
		
		return node;
	}
}
