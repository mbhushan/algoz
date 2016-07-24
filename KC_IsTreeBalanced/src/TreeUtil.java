
class Node {
	Node left;
	Node right;
	Integer data;
	
	Node(int value) {
		this.data = value;
		left = null; right = null;
	}
}
public class TreeUtil {
	
	public static Node tree = null;
	
	public static void main(String [] args) {
		int [] A = {15, 7, 21, 3, 9, 17, 25, 19 };
		int [] B = {15, 7, 21, 3, 9, 17, 25, 19, 20 };
		
		tree = buildBST(tree, A);
		System.out.println("Inorder: ");
		printInorder(tree);
		System.out.println();
		System.out.println("is tree balanced: " + isTreeBalanced(tree));
		
		tree = null;
		tree = buildBST(tree, B);
		System.out.println("Inorder: ");
		printInorder(tree);
		System.out.println();
		System.out.println("is tree balanced: " + isTreeBalanced(tree));
	}
	
	public static boolean isTreeBalanced(Node node) {
		return ((maxDepth(node) - minDepth(node)) <= 1);
	}
	
	public static int maxDepth(Node node) {
		if (null == node) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
		}
	}
	
	public static int minDepth(Node node) {
		if (null == node) {
			return 0;
		} else {
			return 1 + Math.min(minDepth(node.left), minDepth(node.right));
		}
	}
	
	public static void printInorder(Node node) {
		if (null == node) {
			return ;
		} 
		if (null != node.left) {
			printInorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			printInorder(node.right);
		}
		
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (null == A) {
			return null;
		}
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
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

