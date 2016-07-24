import java.util.Random;

class Node {
	int value;
	Node next;
}

public class SingleLinkList {
	static Node head;
	static Random rand = new Random();
	
	static final int N =  5;
	
	public static void main(String[] args) {
		head = buildLinkList(head, N);
		printLinkList();
		head = removeNthFromEnd(head, 5);
		printLinkList();
	}
	
	public static Node removeNthFromEnd(Node node, int k) {
		Node front = node;
		Node back = node;
		Node prev = node;
		
		while ((front.next != null) && (k > 1)) {
			front = front.next;
			--k;
		}
		
		if (front.next == null) {
			return (head.next);
		}
		
		while (front.next  != null ) {
			front = front.next;
			prev = back;
			back = back.next;
		}
		
		prev.next = back.next;
		back.next = null;
		
		return node;
		
	}
	
	public static Node buildLinkList(Node node, int k) {
		if (k == 0) {
			return null;
		} else {
			node = new Node();
			node.value = rand.nextInt(50);
			node.next = buildLinkList(node.next, k-1);
			return node;
		}
	}
	public static void printLinkList() {
		Node current = head;
		while (current !=  null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
}
