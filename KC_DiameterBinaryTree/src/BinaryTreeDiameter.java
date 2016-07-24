import java.util.Random;

class Node  {
	int data;
	Node left;
	Node right;
	
	Node () { data=0; left = null; right = null; }
}
public class BinaryTreeDiameter {
	
	public static Node root = null;
	public static final int N = 10;
	public static final int RANGE = 100;
	public static void main(String [] args)  {
		System.out.println("Building binary tree with following random values:");
		root = buildBinaryTree(root);
		System.out.println();
		System.out.println("Inorder traversal of the binary tree:");
		printBinaryTree(root);
		System.out.println();
		System.out.println("Diameter of BinaryTree: " + diameterOfBinaryTree(root));
	}
	
	public static int diameterOfBinaryTree(Node node) {
		if (null == node) { return 0; }
		else {
			int lHeight = heightOfBinaryTree(node.left);
			int rHeight = heightOfBinaryTree(node.right);
			
			int lDiameter = diameterOfBinaryTree(node.left);
			int rDiameter = diameterOfBinaryTree(node.right);
			
			return Math.max((lHeight+rHeight+1), Math.max(lDiameter, rDiameter));
		}
	}
	
	public static int heightOfBinaryTree(Node node) {
		if (null == node) { return 0; }
		else {
			return Math.max(heightOfBinaryTree(node.left), heightOfBinaryTree(node.right))+1;
		}
	}
	
	public static void printBinaryTree(Node node)  {
		if  (null == node) { return ; }
		else  {
			printBinaryTree(node.left);
			System.out.print(node.data + " ");
			printBinaryTree(node.right);
		}
	}
	public static Node buildBinaryTree(Node root) {
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(RANGE);
			System.out.print(value + " ");
			root = insertBinaryTree(root, value);
		}
		return root;
	}
	
	public static Node insertBinaryTree(Node node, int value) {
		if (null == node) { return newNode(value);  }
		else {
			if (value <= node.data) {
				node.left = insertBinaryTree(node.left, value);
			} else { 
				node.right =  insertBinaryTree(node.right, value);
			}
			return node;
		}
	}
	
	public static Node newNode(int value)  {
		Node node = new Node();
		node.data = value;
		
		return node;
	}
}
 