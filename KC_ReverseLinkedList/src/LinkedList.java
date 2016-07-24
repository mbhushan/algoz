import java.util.Random;


public class LinkedList {
	private static Node root;
	public static void main(String [] args) {
		root = buildLinkedList(root, 5);
		printLinkedList(root);
		root = reverseLL(root);
		System.out.println("printing reversed linked list: ");
		printLinkedList(root);
		root = revSLL(root);
		System.out.println("reversed linked list (yes .. again): ");
		printLinkedList(root);
	}
	
	public static Node revSLL(Node node) {
		Node front = null;
		Node middle = node;
		Node back = null;
		
		while (null != middle) {
			front = middle.next;
			middle.next = back;
			
			back = middle;
			middle = front;
		}
		return back;
		
	}
	
	public static Node reverseLL(Node node) {
		if (null == node || null == node.next) { return node; }
		Node rev = reverseLL(node.next);
		node.next.next = node;
		node.next = null;
		return rev;
	}
	public static void printLinkedList(Node node) {
		if (null == node) { return ; }
		while (null != node) {
			System.out.print(node.data + " => ");
			node = node.next;
		}
		System.out.println("null");
	}
	
	public static Node buildLinkedList(Node node, int size) {
		if (size <= 0) { return null; }
		Random rand = new Random();
		int value = rand.nextInt(98) + 1;
		Node temp = new Node(value);
		node = temp;
		node.next = buildLinkedList(node.next, size-1);
		
		return node;
	}
}

class Node {
	Integer data;
	Node next;
	
	public Node(Integer data) {
		this.data = data;
		next = null;
	}
}
