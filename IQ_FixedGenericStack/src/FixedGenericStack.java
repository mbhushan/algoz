
public class FixedGenericStack<Item> {

	private Item [] A;
	private int N;
	
	FixedGenericStack(int cap) {
		A = (Item []) new Object[cap];
		N = 0;
	}
	
	public int size() { return N; }
	
	public boolean isEmpty() { return N == 0; }
	
	public void push(Item item) {
		A[N++] = item;
	}
	
	public Item pop() {
		return A[--N];
	}
}
