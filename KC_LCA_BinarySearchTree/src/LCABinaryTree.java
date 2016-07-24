
public class LCABinaryTree {
	private static Node root = null;
	
	public static void main(String[] args) {
		
	}
	
	private static Node buildBST(Node node, int [] A) {
		if (null == A) { return node; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
		
	}
	
	private static Node insertIntoBST(Node node, int value) {
		if (null == node) { return new Node(value); }
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}

	
	public static Node lcaBST(Node node, Node a, Node b) {
	    if (null == node || null == a || null == b) { return null; }
	    
	    if (node.data == a.data || node.data == b.data) {
	        return node;
	    }
	    if (a.data < node.data && b.data < node.data) {
	        return lcaBST(node.left, a, b);
	    } else if (a.data > node.data && b.data > node.data) {        
	        return lcaBST(node.right, a, b);        
	    } else {
	        return node;
	    }
	}
}

class Node {
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data) {
		this.data = data;
		left = null; right = null;
	}
}
