import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item> {

	private Node head;
	private int N;
	
	public void add(Item item) {
		Node node = head;
		head = new Node(item);
		head.next = node;
		++N;
	}
	
	public Item removeAfter(Node node) {
		if (null == node || null == node.next) { return null; }
		
		Item item = node.next.item;
		node.next = node.next.next;
		return item;
	}
	
	public Node listHead() { return head; }
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	
	private class Node {
		Node next;
		Item item;
		Node (Item data) {
			item = data;
			next = null;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node node = head;
		
		public boolean hasNext() {
			return (null != node);
		}
		
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() { }
	}
}
