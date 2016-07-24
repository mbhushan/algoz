import java.util.Random;


class Node {
	int data;
	Node next;
}
public class SingleLinkList {
	static Node head = null;
	public static final int len = 6;
	
	public static void main(String[] args) {
		head = buildLinkList(head, len);
		printList();
		head  = swapTwoAdjacent(head, len);
		printList();
	}
	
	public static Node swapTwoAdjacent(Node node, int n) {
		Node X = node;
		Node Y = null;
		Node Z = null;
		Node head = null;
		Y = node.next;
		Z = node.next.next;
		
		Y.next = X;
		X.next = Z;
		if (head == null) { head = Y;}
		Y = X.next;
		Z = Z.next;
		while (Z != null) {			
			Y.next = Z.next;
			Z.next = Y;
			X.next = Z;
			
			X = Y;		
			Y = Y.next;
			if (Y == null) { break; }
			else { Z = Y.next; }
		}
		
		
		return head;
	}
	public static Node buildLinkList(Node node, int k) {
		if (k == 0) { return null;  }
		else {
			Random rand = new Random();
			node = new Node();
			node.data  = rand.nextInt(50);
			node.next = buildLinkList(node.next, k-1);
			return node;
		}
	}
	
	public static void printList() {
		for (Node current=head; current != null; current=current.next){
			System.out.print(current.data + " -> ");
		}
		System.out.println("null");
	}
}
