import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	public Node () { data=0; left = null; right = null; }
}

public class BinaryTreeIsBST {
	private static final int N = 11;
	private static final int RANGE = 100;
	private static Node root;
	
	public static void main(String [] args) {
		root = buildBST(root);
		System.out.println("Is BST: " + isBSTInorder(root, -1));
		printInorder(root);
		System.out.println();
		System.out.println("is BST2: " + isBSTMinMax(root));
	}
	
	private static boolean isBSTMinMax(Node root) {
		return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean isBST2(Node node, int min, int max) {
		if (null == node) { return true; }
		else {
			//left subtree should be in the range of min... node.data
			boolean leftOk = isBST2(node.left, min, node.data);
			
			//bail out if the left is NOT OK
			if (!leftOk) { return false; }
			
			boolean rightOk = isBST2(node.right, node.data+1, max);
			
			return rightOk;
		}
	}
	
	private static boolean isBSTInorder(Node node, int prevData) {
		if (null == node) { return true;  }
		else  {
			isBSTInorder(node.left, prevData);
			if (node.data < prevData) { return false; }
			prevData = node.data;
			isBSTInorder(node.right, prevData);
			return true;
		}
	}
	private static void printInorder(Node node) {
		if (null == node) { return ;  }
		else  {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}
	
	private static Node buildBST(Node node) {
		Random rand =  new Random();
		for (int i=0; i<N; i++) {
			int nodeData = rand.nextInt(RANGE);
			System.out.print(nodeData + " ");
			node = insertIntoBinaryTree(node, nodeData);
		}
		System.out.println();
		return node;
	}
	
	private static Node insertIntoBinaryTree(Node node, int value) {
		if (null == node) { return newNode(value); }
		else {
			if (value <= node.data) {
				node.left = insertIntoBinaryTree(node.left, value);
			} else {
				node.right = insertIntoBinaryTree(node.right, value);
			}
			return node;
		}
	}
	private static Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		return node;
	}

}

