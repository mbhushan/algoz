import java.util.Random;


public class BinaryTreeToDLL {
	
	private static Node root = null;
	private static int N = 7;
	
	public static void main(String[] args) {
		root = buildBST(root);	
		System.out.println("Printing BST inorder: ");
		printBSTInorder(root);
		System.out.println();
		root = treeToList(root);
		System.out.println("Printing the doubly linked list: ");
		printDoubleLinkList(root);
	}
	
	public static void printDoubleLinkList(Node node) {
		Node curr = node;
		while (curr != null) {
			System.out.print(curr.data + " <-> ");
			curr = curr.right;
			if (curr.equals(node)) {
				break;
			}
		}
		System.out.println(" points to head ");
	}
	public static void printBSTInorder(Node node) {
		if (node == null) {
			return ;
		} else {
			if (node.left != null) {
				printBSTInorder(node.left);
			}
			System.out.print(node.data + " ");
			if (node.right != null) {
				printBSTInorder(node.right);
			}
		}
	}
	public static Node treeToList(Node node) {
		if (node == null) { return node; }
		
		Node firstList = treeToList(node.left);
		Node secondList = treeToList(node.right);
		
		node.left = node;
		node.right = node;
		
		firstList = appendNodes(firstList, node);
		firstList = appendNodes(firstList, secondList);
		
		return firstList;
	}
	
	private static Node appendNodes(Node first, Node second) {
		if (first == null) { return second; }
		if (second == null) { return first; }
		
		Node firstLastNode = first.left;
		Node secondLastNode = second.left;
		
		firstLastNode.right = second;
		second.left = firstLastNode;
		
		secondLastNode.right = first;
		first.left = secondLastNode;
		
		return first;
	}
	
	public static Node buildBST(Node node) {
		Random rand = new Random();
		System.out.println("Inserting following values in BST: ");
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(100) + 1;
			System.out.print(value + " ");
			node = insertIntoBST(node, value);
		}
		System.out.println();
		
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
		if (node == null) {
			return new Node(value);
		} else {
			if (value <= node.data) {
				node.left = insertIntoBST(node.left, value);
			} else {
				node.right = insertIntoBST(node.right, value);
			}
			return node;
		}
	}
}

class Node {
	int data;
	Node left;
	Node right;
	
	Node (int data) {
		this.data = data;
		this.left = null;
		this.right = null;		
	}
}