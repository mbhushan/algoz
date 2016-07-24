
public class BinaryTree {
	public static int preIndex = 0;
	public static int BT_SIZE = 7;
	private static Node root = null;
	public static void main(String[] args) {
		int [] in = {5, 9, 7, 8, 2, 10, 3};
		int [] pre = {8, 9, 5, 7, 10, 2, 3};
		
		root = buildTree(root, in, pre, 0, in.length);
		System.out.println("printing inorder of the built binary tree: ");
		printInorder(root);
		System.out.println();
		
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
	
	public static Node buildTree(Node node, int [] in, int [] pre, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		
		if (preIndex < BT_SIZE) {
			node = new Node(pre[preIndex++]);
		}
		
		if (inStart == inEnd) {
			return node;
		}
		
		//find the index of node.data in the inorder array.
		int index = inorderIndex(in, inStart, inEnd, node.data);
		
		node.left = buildTree(node.left, in, pre, inStart, index-1);
		node.right = buildTree(node.right, in, pre, index+1, inEnd);
		
		return node;		
	}
	
	public static int inorderIndex(int [] A, int start, int end, int key) {
		if (null == A) {
			return -1;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			if (A[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	
}

class Node {
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data) {
		this.data = data;
		left = null;
		right = null;
	}
}
