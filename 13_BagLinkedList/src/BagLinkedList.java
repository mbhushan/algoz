import java.util.Iterator;


public class BagLinkedList<Item> implements Iterable<Item> {

	private Node first;
	private int N ;
	
	private class Node {
		Item item;
		Node next;
	}

	public BagLinkedList() {
		first = null;
		N = 0;
	}
	
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		++N;
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
