import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeViews {
	
	private static Node root = null;
	
	public static void main(String[] args) {
		int [] A = {50, 17, 76, 9, 23, 54, 14, 19, 72, 12, 67};
		root = buildBST(root, A);
		System.out.println("printing inorder: ");
		printBST(root);
		System.out.println();
		printLeftNRightViewOfBT(root);
	}
	
	public static void printLeftNRightViewOfBT(Node node) {
		if (null == node) { return ; }
		Queue<Node> queue = new LinkedList<Node>();
		Node marker = new Node(null);
		queue.add(node);
		queue.add(marker);
		
		//boolean wasMarker = false;
		ArrayList<Node> leftViewList = new ArrayList<Node>();
		ArrayList<Node> rightViewList = new ArrayList<Node>();
		leftViewList.add(node);
		//rightViewList.add(node);
		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if (currentNode.equals(marker)) {
				if (!queue.isEmpty()) {
					leftViewList.add(queue.peek());
					queue.add(marker);
				}
			} 
			if (!queue.isEmpty() && queue.peek().equals(marker)) {
				rightViewList.add(currentNode);						
			}
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		Iterator<Node> itLeft = leftViewList.iterator();
		System.out.println("Printing left View: ");
		while (itLeft.hasNext()) {
			System.out.print(itLeft.next().data + " ");
		}
		System.out.println();
		
		System.out.println("Printing right view: ");
		Iterator<Node> itRight = rightViewList.iterator();
		while (itRight.hasNext()) {
			System.out.print(itRight.next().data + " ");
		}
		System.out.println();
	}
	
	public static void printBST(Node node) {
		if (node == null) { return ; }
		if (node.left != null) {
			printBST(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			printBST(node.right);
		}
	}
	
	public static Node buildBST(Node node, int [] A) {
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
		if (node == null) {
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
	
	Node(Integer data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}