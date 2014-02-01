import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N ;
	
	LinkedList() {
		first = null;
		last = null;
		N = 0;
	}
	
	public void add(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
		++N;
	}
	/*
	Iterative solution : To accomplish this task, we maintain references to three consecutive
nodes in the linked list, reverse, front, and second. At each iteration, we extract the
node front from the original linked list and insert it at the beginning of the reversed
list. We maintain the invariant that front is the first node of what’s left of the original
list, second is the second node of what’s left of the original list, and reverse is the first
node of the resulting reversed list.
	 */
	public void reverseIter() {
		Node front = first;
		Node reverse = null;
		
		while (front != null) {
			Node second = front.next;
			front.next = reverse;
			reverse = front;
			front = second;
		}
		first = reverse;
	}
	
	/*
	 * Recursive solution : Assuming the linked list has N nodes, we recursively reverse the last
	 N – 1 nodes, and then carefully append the first node to the end.
	 */
	
	public void reverseRecur() {
		if (isEmpty() || (size() == 1)) {
			return ;
		} else {
			first = reverseRecur(first);
		}
	}
	
	private Node reverseRecur(Node front) {
		if (null == front) { return front; }
		if (null == front.next) { return front; }
		Node second = front.next;
		Node rest = reverseRecur(second);
		second.next = front;
		front.next = null;
		return rest;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	private class Node {
		Node next;
		Item item;
		Node (Item item) {
			this.item = item;
			this.next = null;
		}
		
		public boolean equals(Object obj) {
			if (null == obj) { return false; }
			
			if (this == obj) { return true; }
			
			if (obj.getClass() != this.getClass()) { return false; }
			
			Node node = (Node)obj;
			if (this.item != node.item) { return false; }
			
			return true;
		}
	}
	
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
