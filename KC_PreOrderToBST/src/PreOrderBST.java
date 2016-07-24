import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


//8:05 am
class Node {
	Integer data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data  = data;
		left = null; right = null;
	}
}
public class PreOrderBST {
	private static Node root = null;
	
	public static void main(String [] args) {
//		int [] A = {12, 8, 18, 5, 9, 15, 20};
//		root = buildBST(root, A);
//		System.out.println("inorder: ");
//		inorder(root);
//		System.out.println();
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
//		System.out.println("preorder: ");
//		preorder(root, list);
//		System.out.println();
//		System.out.println("printing pre-order array list: ");
//		printArrayList(list);
		
		int [] pre = {12, 8, 5, 9, 18, 15, 20};
		System.out.println("preorder array to BST: ");
		root = preOrderToBST(pre);
		preorder(root, list);
		System.out.println();
		
		int [] pre2 = {20, 15, 10, 13, 12, 11, 18, 19, 25, 22, 23, 24, 27};
		System.out.println("preorder array to BST: ");
		root = preOrderToBST(pre2);
		list  = new ArrayList<Integer>();
		preorder(root, list);
		
	}
	
	public static Node preOrderToBST(int [] pre) {
		if (null == pre) { return null; }
		
		Stack<Node> stack = new Stack<Node>();
		
		int len = pre.length;
		
		int i=0;
		root = new Node(pre[i++]);
		stack.push(root);
		while (i < len) {
			//if pre[i] is less than stack.peek() then add it as the left child of stack.top and push the pre[i] on stack
			Node node = new Node(pre[i]);
			if (!stack.isEmpty() && (pre[i] <= stack.peek().data)) {
				stack.peek().left = node;
				//stack.push(node);
			} else {
				// pre[i] is greater than stack.top() so pop from stack till stack.top is greater than pre[i] or stack is empty then add pre[i] to stack.
				Node temp = null;
				while (!stack.isEmpty() && stack.peek().data < pre[i]) {
					temp = stack.pop();
				}
				if (null != temp) {
					temp.right = node;
				}
			}
			stack.push(node);
			
			++i;
		}
		
		return root;
	}
	
	
	
	public static void printArrayList(ArrayList<Integer> list) {
		if (null == list) { return ; }
		Iterator<Integer> iter = list.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	public static void printArray(int [] A) {
		if (null == A) { return ; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
	}
	
	public static void preorder(Node node, ArrayList<Integer> list) {
		if (null != node) { 
			System.out.print(node.data + " ");
			list.add(node.data);
			preorder(node.left, list);
			preorder(node.right, list);
		}
		
		
	}
	
	public static void inorder(Node node) {
		if (null == node) { return ; }
		if (null != node.left) {
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			inorder(node.right);
		}
	}
	public static Node buildBST(Node node, int [] A) {
		if (null == A) { return node; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
		if (null == node) { return new Node(value); }
		
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		
		return node;
	}
}
 