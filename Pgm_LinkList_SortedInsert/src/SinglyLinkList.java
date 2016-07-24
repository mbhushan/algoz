import java.util.Random;


public class SinglyLinkList {
	
	private Node head;
	
	class Node {
		Node link;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void builList(int n) {
		head = buildList(head, n);
	}
	
	public Node getHead()  { return this.head; }
	
	public void printList() {
		for (Node curr=head; null != curr; curr=curr.link) {
			System.out.print(curr.data + " -> ");
		}
		System.out.println("null");
	}
	
	public void sortedInsert(int n) {	
		while (n > 0) {
			Random rand = new Random();
			int data = rand.nextInt(99) + 1;
			System.out.print(data  + " ");
			Node node =  new Node(data);
			if (head == null) {				
				head = node;
			} else {
				if  (node.data  <= head.data) {
					node.link = head;
					head =  node;
				} else {
					Node curr = head;
					Node temp = head;
					while (curr.link != null && data > curr.data) {
						temp = curr;
						curr = curr.link;						
					}
					
					if (curr.link == null && data > curr.data) {
						curr.link = node;
					} else {
						node.link = curr;
						temp.link =  node;
					}
				}
			}
			--n;
		}
	}
	
	
	private Node buildList(Node node, int n) {
		if (0==n) { return null; }
		else {
			Random rand = new Random();
			int data = rand.nextInt(99) + 1;
			node = new Node (data);
			node.link = buildList(node.link, n-1);
			return node;
		}
	}
}
