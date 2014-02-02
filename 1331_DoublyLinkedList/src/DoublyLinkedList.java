import java.util.Iterator;


public class DoublyLinkedList<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
		N = 0;
	}
	
	public void removeNode(Item item) {
		if (isEmpty()) { return ; }
		
		Node node = first;
		
		while(node != null) {
		
			if (node.item.equals(item)) {
				//if first node;
				if (node.prev == null) {
					node.next.prev = null;
					node = node.next;
				} else if (node.next == null) { //last node
					node.prev.next = null;
					node = node.prev;
				} else {
					node.prev.next = node.next;
					node.next.prev = node.prev;
				}
				--N;
			}
			node = node.next;
		}
	}
	
	public boolean insertBefore(Item item, Item key) {
		boolean flag = false;
		
		if (isEmpty()) { return flag; }
		Node node = first;
		while(!node.item.equals(item)) {
			node = node.next;
		}
		
		if (null != node) {
			Node temp = new Node(key);
			temp.prev = node.prev;
			temp.next = node;
			node.prev.next = temp;
			node.prev = temp;
			++N;
			flag = true;
		}
		return flag;
	}
	
	public boolean insertAfter(Item item, Item key) {
		boolean flag = false;
		
		if (isEmpty()) { return flag; }
		
		Node node = first;
		while (!node.item.equals(item)) {
			node = node.next;
		}
		if (null != node) {
			Node newNode = new Node(key);
			newNode.next = node.next;
			newNode.prev = node;
			node.next.prev = newNode;
			node.next = newNode;
			flag = true;
			++N;
		}
		return flag;
	}

	public Item removeFront() {
		Item item = null;
		if (isEmpty()) { return item; }
		item = first.item;
		if (size() == 1) {
			first = null;
			last = null;
		} else {
			first.next.prev = null;
			first = first.next;
		}
		--N;
		return item;
	}
	
	public Item removeLast() {
		Item item = null;
		if (isEmpty()) { return item; }
		item = last.item;
		if (size() == 1) {
			last = null;
			first = null;
		} else {
			last.prev.next = null;
			last = last.prev;
		}
		--N;
		return item;
	}
	
	public void addFront(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			Node node = new Node(item);
			node.next = first;
			first.prev = node;
			first = node;
		}
		++N;
	}
	
	public void addBack(Item item) {
		if (isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			Node node = new Node(item);
			node.prev = last;
			last.next = node;
			last = node;
		}
		++N;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	private class Node {
		Item item;
		Node next;
		Node prev;
		public Node(Item item) {
			this.item = item;
			next = null;
			prev = null;
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
