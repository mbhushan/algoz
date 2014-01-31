import java.util.Iterator;

/*
1.3.27 Write a method max() that takes a reference to the first node in a linked list as
argument and returns the value of the maximum key in the list. Assume that all keys are
positive integers, and return 0 if the list is empty.
 */
public class LinkedList implements Iterable<Integer> {

	private Node first;
	private int N;
	
	LinkedList() {
		first = null;
		N = 0;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	public void add(Integer item) {
		if (null == first) {
			first = new Node(item);
		} else {
			Node node = first;
			while (node.next != null) {
				node = node.next;
			}
			Node newNode = new Node(item);
			node.next = newNode;
		}
		++N;
	}
	
	public Integer max() {
		Node node = first;
		if (null == node) { return null; }
		Integer max = node.item;
		while (node.next != null) {
			Integer data = node.next.item;
			if (data > max) {
				max = data;
			}
			node = node.next;
		}
		return max;
	}
	
	private class Node {
		Node next;
		Integer item;
		Node (Integer item) {
			this.item = item;
			this.next = null;
		}
	}
	
	public Iterator<Integer> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Integer> {
		private Node node = first;
		
		public boolean hasNext() { return node != null; }
		
		public Integer next() {
			Integer item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() { }
	}
}
