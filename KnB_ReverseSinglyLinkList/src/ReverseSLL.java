import java.security.KeyStore.Builder;
import java.util.Random;


public class ReverseSLL {
	public static Node head = null;
	public static void main(String [] args) {
		head = buildSLL(head, 7);
		printList(head);
		head = reverseSLL(head);
		printList(head);
		head = reverseIterSLL(head);
		printList(head);
		
	}
	
	public static Node reverseSLL(Node node) {
		if ((node == null) || (node.next == null)) { return node; }
		else {
			Node revHead = reverseSLL(node.next);
			node.next.next = node;
			node.next = null;
			
			return revHead;
		}
	}
	
	public static Node reverseIterSLL(Node node) {
		Node front = null;
		Node middle = node;
		Node back = null;
		
		while (middle != null) {
			front = middle.next;
			middle.next = back;
			
			back = middle;
			middle = front;
		}
		
		return back;		
	}
	
	public static Node buildSLL(Node node, int size) {
		if (size == 0) { return null; }
		else {
			Random rand = new Random();
			int data = 1 + rand.nextInt(98);
			Node newNode = new Node(data);
			node = newNode;
			node.next = buildSLL(node.next, size-1);
			
			return node;
		}
	}
	
	public static void printList(Node node) {
		System.out.println("Printing singly link list: ");
		for (Node temp = node; temp != null; temp = temp.next) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println("null");
	}
}

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}
