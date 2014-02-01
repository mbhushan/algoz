import java.util.Iterator;


public class Queue<Item> implements Iterable<Item> {

	private Node last;
	private int N ;
	
	public Queue() {
		last = null;
		N = 0;
	}
	
	public void enqueue(Item item) {
		Node node = new Node(item);
		if (null == last) {
			last = node;
			last.next = last;
		} else {
			node.next = last.next;
			last.next = node;
			last = node;
		}
		++N;
	}
	
	public Item dequeue() {
		Item item = null;
		if (isEmpty()) { return item; }
		
		item = last.next.item;
		
		if (1 == N) {
			last = null;
		} else {
			last.next = last.next.next;
		}
		--N;
		return item;
	}
	
	public void printQueue() {
		Node node = last.next;
		while (!node.equals(last)) {
			System.out.print(node.item + " -> ");
			node = node.next;
		}
		System.out.print(node.item + " -> ");
		System.out.println(last.next.item);
	}
	
	public Item firstNode() {
		if (null == last) { return null; }
		return last.next.item;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	private class Node {
		Node next;
		Item item;
		Node(Item item) {
			this.item = item;
			this.next = null;
		}
		
		public boolean equals(Object obj) {
			if (this == obj) { return true; }
			
			if (null == obj) { return false; }
			
			if (this.getClass() != obj.getClass()) { return false; }
			
			Node node = (Node)obj;
			
			if (node.item != this.item) { return false; }
			
			return true;
		}
	}
	
	public Iterator<Item> iterator() {
		return new QIterator();
	}
	
	private class QIterator implements Iterator<Item> {
		private Node first = last;
		private int count = N;
		
		public boolean hasNext() {
			return (count != 0);
		}
		
		public Item next() {
			Item item  = first.next.item;
			first = first.next;
			--count;
			
			return item;
		}
		
		public void remove() { }
	}
}
