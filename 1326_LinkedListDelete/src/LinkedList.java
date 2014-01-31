import java.util.Iterator;

/*
1.3.26 Write a method remove() that takes a linked list and a string key as arguments
and removes all of the nodes in the list that have key as its item field.
 */
public class LinkedList<Item> implements Iterable<Item> {

	private Node first;
	private int N;
	
	public LinkedList() {
		first = null;
		N = 0;
	}
	
	public void add(Item item) {
		Node node = first;
		first = new Node(item);
		first.next = node;
		++N;
	}
	
	public void remove(Item item) {
		Node node = first;
		if (null == node) {
			return;
		}
		if (node.item.equals(item)) {
			node = node.next;
			first = node;
			--N;
		}
		while (node != null && node.next != null) {
			while (node.next.item.equals(item)) {
				node.next = node.next.next;
				--N;
			}
			node = node.next;
		}
	}
	
	public boolean isEmpty() { return N == 0; }
	public int size() {return N; }
	
	private class Node {
		Node next;
		Item item;
		Node(Item data) {
			item = data;
			next = null;
		}
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node node = first;
		
		public boolean hasNext() { return node != null; }
		
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() { }
	}
}
