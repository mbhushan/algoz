import java.util.Iterator;


public class StackLinkedList<Item> implements Iterable<Item>{

	private int N = 0;
	private Node first;
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	public void push(Item item) {
		Node node = new Node(item);
		node.next = first;
		first = node;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty!");
			return null;
		}
		Node node = first;
		first = first.next;
		Item item = node.item;
		node = null;
		--N;
		return item;
	}
	
	private class Node {
		Item item;
		Node next;
		
		Node(Item i) {
			item = i;
			next = null;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {
		Node node = first;
		
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
