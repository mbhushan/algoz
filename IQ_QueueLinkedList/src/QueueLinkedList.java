import java.util.Iterator;


public class QueueLinkedList<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N = 0;
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
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
	
	public Item dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty!");
			return null;
		}
		Node node = first;
		first = first.next;
		if (null == first) {
			last = first;
		}
		Item item = node.item;
		node = null;
		--N;
		return item;
	}
	
	private class Node {
		Item item;
		Node next;
		public Node(Item i) {
			item = i;
			next = null;
		}
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		Node node = first;
		
		public boolean hasNext() { 
			return (node != null);
		}
		
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		
		public void remove() {
			
		}
	}
}
