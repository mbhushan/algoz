import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {

	private int N = 0;
	private Item [] A = (Item []) new Object[1];
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	
	public void push(Item item) {
		if (N == A.length) {
			resize(N*2);
		}
		A[N++] = item;
	}
	
	public Item pop() {
		Item item = A[--N];
		A[N] = null; //to avoid loitering.
		if (N > 0 && N == A.length/4) {
			resize(N/2);
		}
		return item;
	}
	
	private void resize(int max) {
		Item [] temp = (Item []) new Object[max];
		for (int i=0; i<N; i++) {
			temp[i] = A[i];
		}
		A = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return A[--i];
		}

		@Override
		public void remove() {}
		
	}
}
