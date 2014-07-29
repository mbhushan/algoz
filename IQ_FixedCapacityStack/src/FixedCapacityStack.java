
public class FixedCapacityStack {

	private String [] A;
	private int N;
	
	public FixedCapacityStack(int n) {
		A = new String[n];
	}
	
	public boolean isEmpty() { return N == 0; }
	
	public int size() { return N; }
	
	public void push(String item) { 
		A[N++] = item;
	}
	
	public String pop() {
		if (!isEmpty()) {
			return A[--N];
		}
		return null;
	}
}
