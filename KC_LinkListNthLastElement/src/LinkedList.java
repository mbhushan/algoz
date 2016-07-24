import java.util.Random;


public class LinkedList {
	
	private static Node head = null;
	public static void main(String[] args) {
		head = buildLinkedList(head, 13);
		printLinkedList(head);
		
		int n = 8;
		Node node = nthNodeInLinkedList(head, n);
		System.out.println(n + "th node from end: " + node.data);
	}
	
	public static Node nthNodeInLinkedList(Node node, int n) {
		if (node == null) { return null; }
		Node front = node;
		Node back = node;
		
		for (int i=1; i<n; i++) {
			front = front.next;
			if (front == null) {
				return null;
			}
		}
		//System.out.println(front.data);
		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		//System.out.println(back.data);
		return back;
		
	}
	public static Node buildLinkedList(Node node, int n) {
		if (n == 0) {
			return null;
		}
		Random rand = new Random();
		int value = rand.nextInt(99);
		node = new Node(value);
		node.next = buildLinkedList(node.next, n-1);
		return node;
	}
	
	private static void printLinkedList(Node node) {
		for (Node temp = node; temp != null; temp=temp.next) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println("null");
	}
}

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
}
