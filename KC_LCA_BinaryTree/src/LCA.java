
public class LCA {
	private static Node root;
	
	public static void main(String [] args) {
		int [] A = {15, 8, 30, 4, 10, 20, 40, 9, 12, 25, 50, 11, 14, 22, 27, 13, 26};
		root = buildBST(root, A);
		
		System.out.println("printing inorder: ");
		inorder(root);
		System.out.println();
		
		Node a = new Node(22);
		Node b = new Node(26);
		
		Node result = lca(root, a, b);
		System.out.println("LCA:: " + result.data);
		
		Node temp = lca2(root, a, b);
		if (null == temp) {
			System.out.println("NO LCA2 Found!");
		} else {
			System.out.println("LCA2: " + temp.data);
		}
	}
	
	public static Node lca2(Node node, Node a, Node b) {
		if (null == node) { return node; }
		if (node.data == a.data || node.data == b.data) { return node; }
		Node L = lca2(node.left, a, b);
		Node R = lca2(node.right, a, b);
		if (null != L && null != R) { return node; } //// if p and q are on both sides
		return (null != L) ? L : R; //// either one of p,q is on one side OR p,q is not in L&R subtrees
	}
	
	public static Node lca(Node node, Node a, Node b) {
		if ((null == node) || (null ==a) || (null == b)) { return null; }
		
		if ((node.data == a.data) || (node.data == b.data)) { return node; }
		int count = countAB(node.left, a, b);
		if (1 == count) { return node; }
		else if (2 == count) { return lca(node.left, a, b); }
		else {  return lca(node.right, a, b); }		
	}
	
	private static int countAB(Node node, Node a, Node b) {
		if (null == node) { return 0; }
		int count = countAB(node.left, a, b) + countAB(node.right, a, b);
		if (node.data == a.data || node.data == b.data) { return 1 + count; }
		else { return count; }
	}
	
	public static void inorder(Node node) {
		if (null == node) { return  ; }
		if (null != node.left) {
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			inorder(node.right);
		}
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (null == A) { return null; }
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
	
	public Node(Integer data) {
		this.data = data;
		left = null;
		right = null;
		
	}
}
