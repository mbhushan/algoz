import java.util.Random;


class Node  {
	int value;
	Node next;
}
public class SingleLinkList {
	static int N = 7;
	static Node head;
	public static void main(String[] args) {	
		head =  buildList(head, N);
		printList();
		head = removeNth(head, 7);
		printList();
	}
	
	public static Node removeNth(Node head, int n) {
		Node current = head;
		Node prev = head;
		if  (n  == 1) {
			return head.next;
		}
		while ((current != null) && (n > 1)) {
			prev = current;
			current = current.next;
			--n;
		}
		if (n==1) {
			if (current.next  != null) {
				prev.next = current.next;
			} else {
				prev.next = null;
			}
		}
		return head;
	}
	
	public static Node buildList(Node node, int k) {
		if (k == 0) { return null; }
		else {
			Random rand = new Random();
			node = new Node();
			node.value = rand.nextInt(50);
			node.next = buildList(node.next, k-1);
			return node;
		}		
	}
	public static void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
}
