import java.util.Random;


class Node {
	int data;
	Node next;
	
	public Node () { data=0; next = null; } 
}
public class SinglyLinkList {
	private static final int N = 7;
	private static final int RANGE = 100;
	private static Node head;
	
	public static void main(String [] args) {
		head = buildLinkList(head, N);
		printList(head);
	}
	
	public static Node buildLinkList(Node node, int n) {
		if (0 == n) { return null; }
		else {
			node = new Node();
			Random rand = new Random();
			
			node.data = rand.nextInt(RANGE);
			node.next = buildLinkList(node.next, n-1);
			
			return node;
		}
	}
	
	public static void printList(Node node) {
		for (Node tmp = node; tmp != null; tmp = tmp.next) {
			System.out.print(tmp.data + " -> ");
		}
		System.out.println("null");
	}
}
