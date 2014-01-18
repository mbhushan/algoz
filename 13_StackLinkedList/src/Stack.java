import java.util.Iterator;


public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public Stack() {
		first = null;
		N = 0;
	}
	
	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		
		node.next = first;
		first = node;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) { return null; }
		
		Item item = first.item;
		first = first.next;
		
		N--;
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			return null;
		} else {
			return first.item;
		}
	}
	
	public boolean isEmpty() { return (null == first); }
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
