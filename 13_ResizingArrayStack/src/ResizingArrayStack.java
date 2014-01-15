import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item [] A = (Item []) new Object[1];
	private int N = 0;
	
	public ResizingArrayStack() {}
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	
	public void push(Item item) {
		if (N == A.length) {
			resize(2*(A.length));
		}
		A[N++] = item;
	}
	
	public Item pop() {
		Item item = A[--N];
		A[N] = null; //to avoid loitering.
		if (N > 0 && N == A.length/4) {
			resize(A.length/2);
		}
		return item;
	}
	
	private void resize(int max) {
		Item [] tmp = (Item []) new Object[max];
		int len = tmp.length;
		for (int i=0; i<N; i++) {
			tmp[i] = A[i];
		}
		A = tmp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		private int I = N;
		@Override
		public boolean hasNext() {
			return (I > 0);
		}

		@Override
		public Item next() {
			return A[--I];
		}

		@Override
		public void remove() {
		}
		
	}
}
