import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	Node () { data =0; left = null; right = null; }
}
public class TreeList {
	private static Node root;
	private static final int N  = 9;
	private static final int RANGE = 100;
	private static Node head ;
	
	public static void main(String [] args) {
		root = buildBST(root);
		
		printBST(root);
		System.out.println();
		head = treeToList(root);
		System.out.println("print doubly list next ...");
		printDoublyList(head);		
	}
	
	private static void printDoublyList(Node node) {
		Node tmp = node;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.right;
			if (tmp == node)  { break; }
		}
		System.out.println();
	}
	
	private static void joinListNodes(Node a, Node b)  {
		a.right = b;
		b.left = a;
	}
	
	private static Node appendLists(Node a, Node b) {
		if (null == a)  { return b; }
		if (null == b) { return a; }
		
		//point to end node of each list
		Node aEnd = a.left;
		Node bEnd = b.left;
		
		//join the lists to make them circular.
		joinListNodes(aEnd, b);
		joinListNodes(bEnd,a);
		
		return a;
	}
	
	private static Node treeToList(Node node) {
		if (null == node) { return null;}
		
		Node aList = treeToList(node.left);
		Node bList = treeToList(node.right);
		
		//make the single root as a list of size 1 in prep for appending to the bigger lists.
		node.left = node;
		node.right = node;
		
		//Now we have 3 sublists aList, Root, and bList. Merge them together.
		aList = appendLists(aList, node);
		aList = appendLists(aList, bList);
		
		return aList;
	}
	
	private static void printBST(Node node) {
		if (null == node) { return ; }
		else {
			printBST(node.left);
			System.out.print(node.data + " ");
			printBST(node.right);
		}
	}
	private static Node buildBST(Node node) {
		Random random = new Random();
		
		for (int i=0; i< N; i++) {
			int value = random.nextInt(RANGE);
			node = insertIntoBST(node, value);
		}
		return node;
	}
	private static Node insertIntoBST(Node node, int value) {
		if (null == node) { return newNode(value); }
		else {
			if (value <= node.data) {
				node.left = insertIntoBST(node.left, value);
			} else {
				node.right = insertIntoBST(node.right, value);
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
