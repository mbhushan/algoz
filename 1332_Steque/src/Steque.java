import java.util.Iterator;


public class Steque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;
	
	public Steque() {
		first = null;
		last = null;
		N = 0;
	}
	
	public void push(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			Node node = first;
			first = new Node(item);
			first.next = node;
		}
		++N;
	}
	
	public Item pop() {
		Item item = null;
		if (isEmpty()) { return item; }
		
		item = first.item;
		
		if (size() == 1) {
			first = null;
			last = null;
		} else {
			first = first.next;
		}
		--N;
		return item;
	}
	
	public void enqueue(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
		++N;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	private class Node {
		Item item;
		Node next;
		Node(Item item) {
			this.item = item;
			next = null;
		}
	}
	
	public Iterator<Item> iterator() {
		return new StequeIterator();
	}
	
	private class StequeIterator implements Iterator<Item> {
		private Node node = first;
		
		public boolean hasNext() {
			return node != null;
		}
		
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() { }
	}
}
