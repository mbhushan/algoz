import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item> {
	
	private class Node {
		Node next;
		Item item;
		public Node() {
			item = null; 
			next = null;
		}
	}
	
	private Node first;
	private int N;
	
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
	
	public boolean find(Item item) {
		if (isEmpty()) { return false; }
		
		for (Node node = first; node != null; node = node.next) {
			Item data = node.item;
			if (data.equals(item)) { 
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() { return (N == 0); }
	public int size() { return N; }
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node node = first;
		
		public boolean hasNext() {
			return (node != null);
		}
		
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() {}
	}
}
