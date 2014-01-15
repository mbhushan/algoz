import java.util.Iterator;


public class Stack<Item> implements Iterable<Item> {
	
	private Item [] S;
	private int N;
	
	public Stack() { 
		S = (Item []) new Object[1];
		N = 0;
	}
	
	public void push(Item item) {
		if (N == S.length) {
			resize(2 * S.length);
		}
		S[N++] = item;
	}
	
	public Item pop() { 
		Item item = S[--N];
		S[N] = null;
		if (N > 0 && N == S.length/4) {
			resize(S.length/2);
		}
		return item;
	}

	public void resize(int max) {
		//move the stack of size N <= max to size of max.
		Item [] tmp = (Item []) new Object[max];
		for (int i=0; i<N; i++) {
			tmp[i] = S[i];
		}
		S = tmp;
	}
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
