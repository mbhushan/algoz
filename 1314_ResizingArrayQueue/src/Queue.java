import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Item [] A = (Item []) new Object[1];
	private int start = 0;
	private int end = 0;
	private int N = 0;
	
	public Queue() {	}
	
	public void enqueue(Item item) {
		if (end == A.length) {
			if (start == 0) {
				resize(2*(A.length));
			} else {
				end = 0;
			}
		} else if (end == start) {
				resize(2*(A.length));
		}
		A[end++] = item;
		++N;
	}
	
	public Item dequeue() {
		Item item = null;
		if (start < A.length) {
			item = A[start++];
		} 
		if (start == A.length) {
			start = 0;
		}
		--N;
		if (N == 0) {
			start = 0;
			end = 0;
		}
		if ((N > 0) && N == (A.length/4)) {
			resize(A.length/2);
		}
		return item;
	}
	
	public void resize(int max) {
		Item [] temp = (Item []) new Object[max];
		int j = 0;
		if (start <= end) {
			for (int i = start; i <end; i++) {
				temp[j++] = A[i];
			}
		} else {
			for (int i=start; i<A.length; i++) {
				temp[j++] = A[i];
			}
			for (int i=0; i<end; i++) {
				temp[j++] = A[i];
			}
		}
		start = 0;
		end = j;
		A = temp;
	}
	
	private void printQueueArr() {
		int len = A.length;
		System.out.println("printing queue array: ");
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
	}
	public int size() {
		return N;
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int capacity() { return A.length; }

	@Override
	public Iterator<Item> iterator() {
		return new QIterator();
	}
	
	private class QIterator implements Iterator<Item> {

		private int curr = start;
		private int I = N;
		@Override
		public boolean hasNext() {
			return (I > 0);
		}

		@Override
		public Item next() {
			Item item = A[curr++];
			if (curr == A.length) {
				curr = 0;
			}
			--I;
			return item;
		}

		@Override
		public void remove() {
		}
	}
}
