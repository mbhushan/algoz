import java.util.Iterator;


public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void enqueue(Item item) {
		Node node = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if (isEmpty()) {
			first = last;
		} else {
			node.next = last;
		}
		++N;
	}
	
	public Item dequeue() {
		if (isEmpty()) { return null; }
		
		Item item = first.item;
		first = first.next;
		
		if (isEmpty()) { last = null; }
		--N;
		return item;
	}
	
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			return (null != current);
		}

		@Override
		public Item next() {
			Item val = current.item;
			current = current.next;
			return val;
		}

		@Override
		public void remove() {
		}
	}
}
