import java.util.Random;


class Node {
	Integer data;
	Node next;
	
	public Node() {
		data = null;
		next = null;
	}
	
}
public class SinglyLinkedList {
	public static Node head = null;
	
	public static void main(String[] args) {
		head = buildSinglyLinkedList(head, 3);
		printSinglyLinkedList(head);
		
		int n = 3;
		Node node = nthNodeFromEndInSinglyLinkedList(head, n);
		if (null != node) {
			System.out.println(n + " node from end: " + node.data);
		} else {
			System.out.println(n + " node from end is null");
		}
		
		n = 7;
		node = nthNodeFromEndInSinglyLinkedList(head, n);
		if (null != node) {
			System.out.println(n + " node from end: " + node.data);
		} else {
			System.out.println(n + " node from end is null");
		}
		
		n = 9;
		node = nthNodeFromEndInSinglyLinkedList(head, n);
		if (null != node) {
			System.out.println(n + " node from end: " + node.data);
		} else {
			System.out.println(n + " node from end is null");
		}
		
		n = 10;
		node = nthNodeFromEndInSinglyLinkedList(head, n);
		if (null != node) {
			System.out.println(n + " node from end: " + node.data);
		} else {
			System.out.println(n + " node from end is null");
		}
		
	}
	
	public static Node nthNodeFromEndInSinglyLinkedList(Node node, int n) {
		if (null == node || n < 1) {
			return node;
		}
		Node current = node;
		Node previous = node;
		
		while (n > 0) {
			if (null == current) {
				return null;
			}
			current = current.next;
			--n;
		}
		
		while (null != current) {
			current = current.next;
			previous = previous.next;
		}
		
		return previous;
		
	}
	
	public static Node buildSinglyLinkedList(Node node, int n) {
		if (0 == n) {
			return null;
		}
		node = new Node();
		Random rand = new Random();
		int value = rand.nextInt(99);
		node.data = value;
		node.next = buildSinglyLinkedList(node, n-1);
		return node;
	}
	
	public static void printSinglyLinkedList(Node node) {
		if (null == node) {
			System.out.println("null");
			return ;
		}
		for (Node tmp=node; tmp != null; tmp = tmp.next) {
			System.out.print(tmp.data + " -> ");
		}
		System.out.println("null");
	}
}
