import java.util.Random;


public class ReverseList {
	
	private Node head;
	private int N = 1;
	class Node {
		int data;
		Node next;
		
		Node(int data) { this.data=data; next=null; }
	}
	
	public ReverseList() {
		head = null;
	}
	
	public static void main(String [] args) {
		ReverseList rl = new ReverseList();
		rl.buildList();
		rl.printList();
		
		System.out.println("reversing recursively:");
		rl.reverseList();
		
		System.out.println("reversing iteratively:");
		rl.reverseIteratively();
	}
	
	public void reverseIteratively() {
		Node front = null;
		Node middle = head;
		Node back = null;
		
		while (middle  != null ) {
			front = middle.next;
			middle.next = back;
			
			back = middle;
			middle = front;
		}
		
		head = back;
		
		printList();
	}
	
	public void reverseList() {
		head = reverse(head);
		printList();
	}
	
	private Node reverse(Node node) {
		if (null == node  || node.next == null) { return node; }
		else {
			Node key = reverse(node.next);
			node.next.next = node;
			node.next = null;
			return key;
		}
	}
	public void printList() {
		for (Node node=head; null != node; node=node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println("null");
	}
	public void buildList() {
		head = buildList(head,N);
	}
	
	private Node buildList(Node node, int n) {
		if (n==0) { return null; }
		else {
			int data = new Random().nextInt(99)+1;
			Node newNode = new Node(data);
			node = newNode;
			node.next =  buildList(node.next, n-1);
			return node;
		}
	}
}
