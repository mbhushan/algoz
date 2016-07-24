import java.util.Random;


public class LinkListBasic {
	
	private Node head;
	
	class Node {
		Node link;
		int data;
		
		Node(int value) { link = null; this.data = value; }
	}
	
	public LinkListBasic() {
		head = null;
	}
	
	public void buildList(int n) {
		head = buildList(head, n);
	}
	
	public void printList() {
		for (Node temp=head; temp != null; temp=temp.link) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println("null");
	}
	
	public int  countNodes() {
		int count = 0;
		
		for (Node temp=head; null != temp; temp=temp.link) {
			++count;
		}
		return count;
	}
	
	public int getNthNode(int n) {
		int len = this.countNodes();
		int result = -1;
		if (n > len || n <= 0) {
			System.out.println("requested node is not a valid request!!");
		} else {
			int i=1;
			for (Node temp=head; null!=temp; temp=temp.link,i++) {
				if (i == n) {
					result = temp.data;
					break;
				}
			}
		}
		return result;
	}
	
	public void deleteList() {
		head = null;
	}
	public int popFromList() {
		if (null == head) { return -1; }
		else {
			int data = head.data;
			head = head.link;
			
			return data;
		}
	}
	
	public void insertNth(int n) {
		Random rand = new Random();
		int value = rand.nextInt(99) + 1;
		Node node = new Node(value);
		if (1==n) {
			node.link = head;
			head = node;
			return;
		}
		Node current = head;
		n=n-1;		
		while (null != current.link && n>1) {
			current = current.link;
			--n;
		}
		node.link = current.link;
		current.link = node;
	}
	private Node buildList(Node node, int n) {
		if (0 == n) { return null; }
		else {
			Random rand = new Random();
			int value = rand.nextInt(99) + 1;
			node = new Node(value);
			node.link = buildList(node.link, n-1);
			
			return node;
		}
	}
}
