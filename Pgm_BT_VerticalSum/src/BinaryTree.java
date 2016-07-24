import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class BinaryTree {
	
	class Node {
		int data; Node left; Node right;
		public Node(int data) {
			this.data = data;
			left = null; right = null;
		}
	}
	
	private Node root;
	private Map<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();
	
	public BinaryTree() {
		root = null;
	}
	
	public void buildBST(int [] A) {
		int len = A.length;
		for (int i=0; i<len; i++) {
			root = buildBST(root, A[i]);
			System.out.println("inserting " + A[i]);
		}
	}
	
	public void printInorderIterative() {
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		
		System.out.println("printing inorder: ");
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
			
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
	public void verticalSum() {
		calcVerticalSum(root, 0);
		Set set = verticalSum.entrySet();
		
		Iterator iter = set.iterator();
		System.out.println("printing the vertical sums: :)");
		while (iter.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iter.next();
			System.out.print(entry.getValue() + " ");
		}
		System.out.println("its done baby !!!");
	}
	
	private void calcVerticalSum(Node node, int col) {
		if (node == null) { return ; }
		if (node.left != null) {
			calcVerticalSum(node.left, col-1);
		}
		if (verticalSum.containsKey(col)) {
			int value  = verticalSum.get(col);
			verticalSum.put(col, value+node.data);
		} else {
			verticalSum.put(col, node.data);
		}
		if (node.right != null) {
			calcVerticalSum(node.right, col+1);
		}
	}
	public void inorder() {
		System.out.println("printing inorder recursively: ");
		inorder(root);
		
		System.out.println("done :)");
	}
	
	private void inorder(Node node) {
		if (node == null) { return ; }
		if (node.left != null) { inorder(node.left); }
		System.out.print(node.data + " ");
		if (node.right != null) { inorder(node.right);  }
	}
	
	private Node buildBST(Node node, int value) {
		if (node == null) { return new Node(value);  }
		if  (value <= node.data) {
			node.left = buildBST(node.left, value);
		} else {
			node.right = buildBST(node.right, value);
		}
		return node;
	}
}
