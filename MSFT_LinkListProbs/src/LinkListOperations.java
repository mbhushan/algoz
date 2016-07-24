import java.util.Random;


class Node {
	int data;
	Node next;
	
	public Node () { data = 0; next = null; }
}

public class LinkListOperations {
	
	private static final int N = 7;
	private static final int RANGE = 100;
	private static Node head ;
	
	public static void main(String [] args) {
		head = buildList(head, N);
		printList(head);
		appendToList(100);
		printList(head);
		deleteFromList(100);
		printList(head);
		appendToHead(1);
		printList(head);
		removeHead();
		printList(head);
	}
	
	public static void removeHead() {
		Node tmp = head;
		head = head.next;
		tmp.next = null;
	}
	
	public static void appendToHead(int value) {
		Node node = new Node();
		node.data = value;
		node.next = head;
		head = node;
	}
	public static void deleteFromList(int value) {
		//delete head;
		if (head.data == value) {
			Node tmp = head;
			head = tmp.next;
			tmp.next = null;
		} 
		
		Node current = head;
		
		while (null  != current.next && value != current.next.data) {
			current =  current.next;
		}
		
		if (null != current.next)  {
			Node tmp = current.next;
			current.next = current.next.next;
			tmp.next = null;
		}
		
	}
	
	public static void appendToList(int nodeData) {
		
		if (null == head) {
			head = new Node();
			head.data = nodeData;
		}
		Node tmp = head;
		
		while (tmp.next != null) { 
			tmp = tmp.next;
		}
		Node node = new Node();
		node.data = nodeData;
		tmp.next = node;
	}
	
	public static Node buildList(Node node, int n) {
		if (0 == n) { return null; }
		else {
			node = new Node();
			node.data = (new Random().nextInt(RANGE));
			node.next = buildList(node.next, n-1);
			
			return node;
		}
	}
	
	public static void printList(Node node) {
		for (Node tmp = node; tmp != null ; tmp = tmp.next) {
			System.out.print(tmp.data + " -> ");
		}
		System.out.println("null");
	}
}
