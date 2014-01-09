
public class Counter {

	private final String name;
	private int count;
	
	Counter(String id) {
		this.name = id;
	}
	
	public void increment() {
		++count;
	}
	
	public int tally() { return count; }
	
	public String toString() { return name + " " + count; }
}
