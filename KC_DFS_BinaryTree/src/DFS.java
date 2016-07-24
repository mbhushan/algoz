import java.util.HashMap;
import java.util.Stack;


public class DFS {
	private static Node root = null;
	
	public static void main(String[] args) {
		int [] arr = {9, 5, 13, 2, 7, 11, 15};
		root = buildBST(root, arr);
		//printInorder(root);
	//	inorder(root);
		//dfsIter(root);
		System.out.println("printing pre-Order (dfs) for a binary tree: ");
		preOrder(root);
		System.out.println();
		
		System.out.println("postOrder iterative: ");
		postOrder(root);
	}
	
	public static void postOrder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		System.out.println("inside postOrder");
		while ((null != node) || !stack.isEmpty()) {
			if (null != node) {
				stack.push(node);
				node = node.left;
			}
			if (null == node) {
				while (!stack.isEmpty() && stack.peek().right == node) {
					node = stack.pop();
					System.out.print(node.data + " ");
				}
				node = stack.isEmpty() ? null : stack.peek().right;

			}
			
		}
	}
	public static void preOrder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while ((null != node) || !stack.isEmpty()) {
			if (null == node) {
				node = stack.pop();
			}
			if (null != node) {
				System.out.print(node.data + " ");
			}
			if (null != node.right) {
				stack.push(node.right);
			}
			node = node.left;
//			if (null == node) {
//				node = stack.pop();
//			}
		}
	}
	
	public static void dfsIter(Node node) {
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();
		
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.peek();
			//if no unvisited kids are found then pop it from stack
			if (node.left != null && !visitedMap.containsKey(node.left)) {
				stack.push(node.left);
				visitedMap.put(node.left, true);
			} else if (node.right != null && !visitedMap.containsKey(node.right)) {
				stack.push(node.right);
				visitedMap.put(node.right, true);
			} else {
				System.out.print(stack.pop().data + " ");
			}
		}
		System.out.println("done");
	}
	
	public static void inorder(Node node) {
		if (null != node) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	public static void printInorder(Node node) {
		if (null == node) { return; }
		System.out.println("inside print");
		Stack<Node> stack = new Stack<Node>();
		
		while ((null != node) || !stack.isEmpty()) {
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
	}
	
	public static Node buildBST(Node node, int [] arr) {
		if (null == arr) { return node; }
		int len = arr.length;
		//System.out.println("inside build BST");
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, arr[i]);
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
