
public class FixedCapacityStack<Item> {

	private Item [] A;
	private int N;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		//as we cannot create generic array in java
		A = (Item []) new Object[cap]; 
	}
	
	public boolean isEmpty() {
		return (N == 0);
	}
	
	public int size() { return N; }
	
	public void push(Item item) {
		A[N++] = item;
	}
	
	public Item pop() {
		return A[--N];
	}
}
