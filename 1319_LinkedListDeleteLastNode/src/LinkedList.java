import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item>{
	
	private class Node {
		Item item;
		Node next;
		public Node() {
			item = null; next = null;
		}
	}
	
	private Node first;
	private int N;
	
	public LinkedList() {
		first = null;
		N = 0;
	}
	
	public void add(Item item) {
		Node curr = first;
		first = new Node();
		first.item = item;
		first.next = curr;
		++N;
	}
	
	public Item removeLastNode() {
		Item item = null;
		if (isEmpty()) { return item; }
		
		if (first.next == null) {
			item = first.item;
			first = null;
			--N;
			return item;
		}
		Node node = first;
		while (node.next.next != null) {
			node = node.next;
		}
		item = node.next.item;
		node.next = null;
		--N;
		return item;
	}
	
	public int size() { return N; }
	public boolean isEmpty() { return (N == 0); }
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node curr = first;
		
		public boolean hasNext() {
			return (curr != null);
		}
		
		public Item next() {
			Item item = curr.item;
			curr = curr.next;
			return item;
		}
		
		public void remove() {		}
	}
}
