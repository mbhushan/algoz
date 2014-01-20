import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item>{

	private class Node {
		Item item;
		Node next;
		public Node() {
			item = null;
			next = null;
		}
	}
	
	private Node first;
	private int N ;
	
	public LinkedList() {
		first = null;
		N = 0;
	}
	
	public void add(Item item) {
		Node node = first;
		first = new Node();
		first.item = item;
		first.next = node;
		++N;
	}
	
	public Item delete(int k) {
		if (k < 1 || k > N) {
			return null;
		}
		Item item = null;
		
		if (1 == k) {
			item = first.item;
			first = first.next;
			return item;
		}
		Node node = first;
		for (int i=2; i<k; i++) {
			node = node.next;
		}
		
		item = node.next.item;
		node.next = node.next.next;
		--N;
		return item;
	}
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		Node node = first;
		
		public boolean hasNext() {
			return (node != null);
		}
		
		public Item next() {
			Item item = null;
			item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() { }
	}
}
